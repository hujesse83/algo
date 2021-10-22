package zero_50.stackAndqueue;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1, 1, 2, 1, 1, 2, 3, 4};
        System.out.println(Arrays.toString(topKFrequent2(nums, 2)));
    }

    // 一顿操作梦如虎，一看击败5%
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map.entrySet()
                .stream()
                .sorted((m1, m2) -> m2.getValue() - m1.getValue())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    //2、PriorityQueue(优先队列).Java中PriorityQueue通过二叉小顶堆实现
    public static int[] topKFrequent2(int[] nums, int k) {
        if (k == nums.length)
            return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 1) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue =
                new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());//从大到小排序
        priorityQueue.addAll(entrySet);
        int cnt = 0;
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[cnt++] = priorityQueue.poll().getKey();
        }
        return ans;
    }

}
