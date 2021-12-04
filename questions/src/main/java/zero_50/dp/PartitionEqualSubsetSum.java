package zero_50.dp;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/4 15:57
 * @Description Given a non-empty array nums containing only positive integers,
 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 * 我们只需要找到sum/2 的子集就可以了。剩下的和不就是sum/2吗。
 *
 *
 */
public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum%2==1){ //奇数
            return false;
        }
        int bagSize = sum/2;
        int []dp = new int[bagSize+1];
        for(int i = 0; i < nums.length; i++) { // 遍历物品
            for(int j = bagSize; j >= nums[i]; j--) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[bagSize]==bagSize;
    }


}
