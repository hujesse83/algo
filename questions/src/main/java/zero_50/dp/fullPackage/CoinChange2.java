package zero_50.dp.fullPackage;


import java.util.Arrays;

/**
 * LC 518 超级经典
 * @Author huJesse
 * @Date 2021/12/8 16:26
 * 这是一道典型的背包问题，一看到钱币数量不限，就知道这是一个完全背包。
 *
 * 组合不强调元素之间的顺序，排列强调元素之间的顺序
 *
 * 过了3天没做题，dp数组含义都忘了
 * 1、确定dp数组以及下标的含义
 * dp[j]：凑成总金额j的货币组合数为dp[j]
 * 2、确定递推公式
 * dp[j] += dp[j - coins[i]]; 不装+装的总数。
 */
public class CoinChange2 {
    public int change(int amount, int[] coins) {
        int dp[] = new int[amount + 1];
        // 设置起始状态
        dp[0] = 1;

       // 这样遍历确定的是组合数量。
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        /**这样遍历确定的是排列数量
        for (int j = 0; j <=amount ; j++) {
            for (int i = 0; i <coins.length ; i++) {
                if (j-coins[i]>=0){
                    dp[j]+=dp[j-coins[i]];
                }
            }
        }
         */
        System.out.println(Arrays.toString(dp));
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] num = {1, 2};
        System.out.println(new CoinChange2().change(3, num));
    }
}
