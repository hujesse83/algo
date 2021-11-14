package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合
 * @Time 2021/11/14 23:19
 *擦 想不明白... 明日再战
 */
public class Combinations {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> item = new ArrayList<>();
        for (int i = 1; i <n ; i++) {
            backTrace(i,n,k,item);
        }
        return res;
    }
    public void backTrace(int begin,int n,int k,List<Integer> item){
        if (begin==n){
            return;
        }
        item.add(begin);
        if (item.size()==k){
            ArrayList<Integer> newItem = new ArrayList<>(item);
            res.add(newItem);
            item.remove(item.size()-1);
        }
        backTrace(begin+1,n,k,item);
    }
}
