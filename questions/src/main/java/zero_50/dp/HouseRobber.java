package zero_50.dp;

/**
 * @Date 2021/12/21 14:29
 * @Description 打家劫舍 不能选相邻的数字...只能间隔间隔地选
 * 做了太久的01背包.. 怎么把dp默认为01背包了呀..QAQ
 * :star LC198
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length==0 || nums==null){
            return 0;
        }
        if (nums.length==1) return nums[0];
        int []dp = new int[nums.length];  // 1、确认dp数组以及下标的含义。考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]。
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+ nums[i]);
        }
        return dp[nums.length-1];
    }

    public static void main(String[] args) {
        int []nums = {2,7,9};
        new HouseRobber().rob(nums);
    }
}
