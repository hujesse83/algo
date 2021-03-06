package zero_50.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/16 20:51
 * LC 39
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 */
public class CombinationSum {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();

    // 剪枝优化 排序数组 + target < 0
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(candidates, target, 0);
        return res;
    }

    public void backTrace(int[] candidates, int target, int index) {
        if (target == 0) {
            res.add(new ArrayList<>(item));
            return;
        }
        // for循环之上剪枝
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                return;
            }
            item.add(candidates[i]);
            backTrace(candidates, target - candidates[i], i);
            item.remove(item.size() - 1);
        }
    }
}
