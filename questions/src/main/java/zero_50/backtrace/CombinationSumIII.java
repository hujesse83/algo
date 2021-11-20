package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 216 在1-10中选出k个数，sum = n
 * I made it on my own
 */
public class CombinationSumIII {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backTrace(1, k, n);
        return res;
    }

    // begin[1,10] k = 个数 n为总和
    public void backTrace(int begin, int k, int n) {
        if (k == item.size() && n == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (n < 0) {
            return;
        }
        for (int i = begin; i < 10; i++) {
            item.add(i);
            backTrace(i + 1, k, n - i); // 这样保证了begin是升序，相当于剪枝了
            item.remove(item.size() - 1);
        }
    }
}
