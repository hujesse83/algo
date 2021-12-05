package zero_50.dp;

/**
 * @Author huJesse
 * @Date 2021/12/5 16:42
 * @LC 494
 * @Description 使用dfs方法.. 经典
 */
public class TargetSumDFS {
    private int res;

    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, target, 0);
        return res;
    }

    // V2 dfs
    public void dfs(int[] nums, int target, int index) {
        if (index == nums.length) { // 元素全部用完
            if (target == 0) {
                res++;
            }
            return;
        }
        dfs(nums, target - nums[index], index + 1); //
        dfs(nums, target + nums[index], index + 1);
    }
}
