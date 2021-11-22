package zero_50.backtrace;

import java.util.*;

/**
 * @Author huJesse
 * @Date 2021/11/21 21:36
 * @Description Hard https://programmercarl.com/0332.%E9%87%8D%E6%96%B0%E5%AE%89%E6%8E%92%E8%A1%8C%E7%A8%8B.html#%E6%80%BB%E7%BB%93
 * LC 322 重新安排行程、
 * 真的挺难
 */
public class ReconstructItinerary {
    private Deque<String> res = new LinkedList<>();
    private Map<String, TreeMap<String, Integer>> map = new HashMap<>();

    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();
        if(map.containsKey(last)){//防止出现null
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();
                if(count > 0){
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)) return true;
                    res.removeLast();
                    target.setValue(count); // count 回溯
                }
            }
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from,new TreeMap<>());
            TreeMap<String,Integer> treeMap = map.get(from);
            treeMap.put(to,treeMap.getOrDefault(to,0)+1);
        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<List<String>> all = new ArrayList<>();
        List<String> item = new ArrayList<>();
        item.add("MUC");
        item.add("LHR");
        all.add(new ArrayList<>(item));
        item.clear();
        item.add("JFK");
        item.add("MUC");
        all.add(new ArrayList<>(item));
        item.clear();
        item.add("SFO");
        item.add("SJC");
        all.add(new ArrayList<>(item));
        item.clear();
        item.add("LHR");
        item.add("SFO");
        all.add(new ArrayList<>(item));
        System.out.println(all);
        System.out.println(new ReconstructItinerary().findItinerary(all)); ;
    }

}
