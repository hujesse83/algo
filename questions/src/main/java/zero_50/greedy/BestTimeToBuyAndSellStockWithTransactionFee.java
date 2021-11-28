package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/28 15:51
 * 1、贪心思想 我是脑瘫 想了2小时还是没想通 LC 714 买卖股票有手续费
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    // 重点是进入连续获利区间内，如何只扣一次手续费；
    public int maxProfit(int[] prices, int fee) {
        int result = 0;
        int minPrice = prices[0]; // 记录最低价格
        for (int i = 1; i < prices.length; i++) {
            // 情况二：相当于买入
            if (prices[i] < minPrice) minPrice = prices[i];

            // 计算利润，可能有多次计算利润，最后一次计算利润才是真正意义的卖出
            if (prices[i] > minPrice + fee) {
                result += prices[i] - minPrice - fee;
                minPrice = prices[i] - fee; // 情况一，这一步很关键。从代码中可以看出对情况一的操作，因为如果还在收获利润的区间里，表示并不是真正的卖出，而计算利润每次都要减去手续费，所以要让minPrice = prices[i] - fee;，这样在明天收获利润的时候，才不会多减一次手续费
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 7, 5, 10, 3};
        System.out.println(new BestTimeToBuyAndSellStockWithTransactionFee().maxProfit(nums, 3));
    }
}
