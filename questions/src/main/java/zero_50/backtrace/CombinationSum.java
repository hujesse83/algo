package zero_50.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/16 20:51
 * LC 39
 */
public class CombinationSum {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();

    // 剪枝优化 排序数组 + target < 0
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length == 0) {
            return res;
        }
        backTrace(candidates, target, 0);
        return res;
    }

    public void backTrace(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        if (target < 0) {
            return;
        }
        // for循环之上剪枝
        for (int i = index; i < candidates.length && target - candidates[i] >= 0; i++) {
            item.add(candidates[i]);
            backTrace(candidates, target - candidates[i], i);
            item.remove(item.size() - 1);
        }
    }
}
