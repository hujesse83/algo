package zero_50.dp.fullPackage;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/10 23:42
 * 之前的爬楼梯采用的最直接的dp，Fibonacci数列。
 * 这次采用完全背包方法来解决 问跳到楼顶有几种方法其实就是问装满背包有几种方法。
 * LC 70
 * dp[i]有几种来源，dp[i - 1]，dp[i - 2]，dp[i - 3] 等等，即：dp[i - j]
 * 那么递推公式为：dp[i] += dp[i - j]
 * <p>
 * 这道题Debug一下就会与完全背包联系起来了。
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1]; // 爬到有i个台阶的楼顶，有dp[i]种方法。
        dp[0] = 1;
        int[] step = {1, 2};
        // 注意这里是排列,外层使用重量
        for (int j = 1; j <= n; j++) {
            for (int i = 0; i < step.length; i++) {
                if (j - step[i] >= 0) {
                    dp[j] = dp[j] + dp[j - step[i]];
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        new ClimbingStairs().climbStairs(5);
    }
}
