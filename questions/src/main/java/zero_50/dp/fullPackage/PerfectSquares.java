package zero_50.dp.fullPackage;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/12 17:11
 * LC 279
 * @Description ：Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * 参考：https://programmercarl.com/0279.%E5%AE%8C%E5%85%A8%E5%B9%B3%E6%96%B9%E6%95%B0.html#%E6%80%9D%E8%B7%AF
 */
public class PerfectSquares {
    public int numSquares(int n) {
        int dp[] = new int[n + 1]; //1、和为i的完全平方数的最少数量为dp[i]
        int max = Integer.MAX_VALUE;
        Arrays.fill(dp, max);
        dp[0] = 0;
        int top = (int) Math.sqrt(n);
        int[] weight = new int[top + 1];
        for (int i = 0; i < weight.length; i++) {
            weight[i] = i * i;
        }
        System.out.println(top);
        System.out.println(Arrays.toString(weight));
        for (int i = 1; i <= top; i++) {  // 遍历物品
            for (int j = weight[i]; j <= n; j++) {  // 遍历容量
                if (dp[j - weight[i]] != max) {
                    dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1); // 为什么要拿dp[i]进去比呢？是因为dp[i]从dp[j-weight[i]]中取最小的，需要保存变量
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        new PerfectSquares().numSquares(9);  // debug一下就清楚了
    }
}
