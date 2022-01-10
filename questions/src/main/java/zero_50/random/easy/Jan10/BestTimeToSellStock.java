package zero_50.random.easy.Jan10;

/**
 * @author jesse.hu
 * @date 2022/1/10 16:09
 * @LeetCodeNo 121
 */
public class BestTimeToSellStock {
    // 法1：我没做出来 DP

    /**
     * 第i天收益只需要知道前i天第最低点就可以算出来了. 而第i天（包括i天）第最低点和i-1天第最低点有关.
     * dp[i] = min(d[i-1],prices[i])
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(prices[i], dp[i - 1]);
            max = Math.max(prices[i] - dp[i], max);
        }
        return max;
    }

    // Math.max min 确实要比if () ... 赋值慢
    public int maxProfitV2(int[] prices) {
        // 贪心.取最左最小值、取最右最大值
        int low = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low, prices[i]);
            max = Math.max(prices[i] - low, max);
        }
        return max;
    }
}
