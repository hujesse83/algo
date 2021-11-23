package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/23 00:42
 * [7,1,5,3,6,4] 7
 * [1,2,3,4,5] 4
 * [7,6,4,3,1] 0
 * 只收集每天的正利润，最后稳稳的就是最大利润了 LC122
 */
public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1]>prices[i]){
                sum+=prices[i+1]-prices[i];
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int []p = {7,1,5,3,6,4};
        System.out.println(BestTimeToBuyAndSellStockII.maxProfit(p));
    }

}
