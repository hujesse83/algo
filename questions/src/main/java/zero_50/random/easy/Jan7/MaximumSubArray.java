package zero_50.random.easy.Jan7;

import java.util.Arrays;

/**
 * @author jesse.hu
 * @date 2022/1/7 14:36
 * @LeetCodeNo 48 :sta:star
 */
public class MaximumSubArray {
    // 方法一：贪心. 若当前指针所指元素的和小于0，则丢弃当前元素之前的序列.
    public int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            count+=nums[i];
            sum = Math.max(sum,count);
            if (count<0){
                count = 0;
            }
        }
        return  sum;
    }
    // 方法二、动态规格, 当前状态与上一个状态有关
    public int maxSubArrayDP(int[] nums) {
        int temp = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            temp = Math.max(temp, dp[i]);  // stream 耗时较多.
        }
       // return Arrays.stream(dp).max().getAsInt();  10ms -> 3ms
        return temp;
    }

}
