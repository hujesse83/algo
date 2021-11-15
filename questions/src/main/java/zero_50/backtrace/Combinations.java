package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 组合
 * @Time 2021/11/14 23:19
 * 擦 想不明白... 明日再战
 * @Time 2021/11/15 11:21
 * 我们需要区分排列和组合，组合没有顺序 [1,2] = [2,1]
 */
public class Combinations {
    // V1 没做剪枝操作的 16ms
    public static List<List<Integer>> res = new ArrayList<>();
    public static List<Integer> item = new ArrayList<>();

    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> item = new ArrayList<>();
        backTrace(1, n, k);
        return res;
    }

    public static void backTrace(int begin, int n, int k) {
        if (item.size() == k) {
            ArrayList<Integer> temp = new ArrayList<>(item);
            res.add(temp);
            return;
        }
        // 减枝的操作就在这里 n-(k-item.size())+1 表示至多起始位置
        for (int i = begin; i <= n - (k - item.size()) + 1; i++) {
            item.add(i);
            backTrace(i + 1, n, k);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        combine(4, 4);
    }
    /**
     * 剪枝算是非常重要的操作了 从16ms到1ms。
     */
}
