package zero_50.random.easy.Jan8;

/**
 * @author jesse.hu
 * @date 2022/1/9 00:14
 * @LeetCodeNo 70
 * @Desc You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 特别经典的一道题. :star
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
}
