package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/21 18:12
 * @Description 求递增子集 + 去重的问题 LC491
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 */
public class IncreasingSubsequences {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return res;
    }

    private void backtracking(int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        int[] used = new int[201]; // 保证了每一层的去重！妙啊 ，因为题目给定了-100<=nums[i]<=100 每一个栈都拥有一个used数组。利用数组替代哈希
        /**
         * 这里的去重与SubsetsII的去重又不一样了，前者是排好序的。而我没有排好序。
         */
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) continue;
            used[nums[i] + 100] = 1;  // 为什么需要 +100呢，当nums[i] 为-100的时候，对应hash表index为0的位置
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
