package zero_50.dp.fullPackage;

/**
 * LC377 超级经典 全背包组合问题
 * @Author huJesse
 * @Date 2021/12/9 09:29
 * Given an array of distinct integers nums and a target integer target,
 * return the number of possible combinations that add up to target.
 * 全背包 排列问题
 *
 */
public class CombinationSumIV {
    public int combinationSum4(int[] nums, int target) {
        int dp[] = new int[target+1]; //凑成目标正整数为i的排列个数为dp[i]
        dp[0] = 1;
        //dp[i]=dp[i-nums[0]]+dp[i-nums[1]]+dp[i-nums[2]]+...
        //举个例子比如nums=[1,2],target=3;
        //dp[3]=dp[1]+dp[2]
        //其实就是说3的组合数可以由三部分组成，1和dp[2]，2和dp[1];
        for (int j = 0; j <=target ; j++) {  // 先遍历重量
            for (int i = 0; i <nums.length ; i++) {
                if (j-nums[i]>=0){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int []nums = {1,2};
        new CombinationSumIV().combinationSum4(nums,3);
    }
}
