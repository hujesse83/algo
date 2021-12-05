package zero_50.dp;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/5 15:41
 * 此时问题就是在集合nums中找出和为left的组合。
 * 装满容量为x背包，有几种方法。当初卡在了有多少种的选择上 . 即为dp[i]表示的是可供选择的数量而不是价值了..
 * 本题则是装满有几种方法。其实这就是一个组合问题了。
 * dp[j] 表示：填满j（包括j）这么大容积的包，有dp[i]种方法
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 * 组合成容量为sum(P)的方式有多少种
 */
public class TargetSumDP {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 != 0) {
            return 0;
        }
        int size = Math.abs((target + sum) / 2);
        int[] dp = new int[size + 1];
        dp[0] = 1;
        /**
         * dp[j] = dp[j] + dp[j - num]，
         * //dp[j]不放入当前背包,dp[j - num]放入当前背包 当前填满容量为j的包的方法数 = 之前填满容量为j的包的方法数 （不放） + 之前填满容量为j - num的包的方法数 （放入）
         * 也就是当前数num的加入，可以把之前和为j - num的方法数加入进来。
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];  // 组合问题 需要并集操作
            }
        }
        return dp[size];
    }
}
