package zero_50.dp.fullPackage;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/11 00:11
 * @LC 322 零钱兑换 注意了这里是求组合数量最小的情况
 * 1、凑足总额为j所需钱币的最少个数为dp[j]
 * 2、得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]（没有考虑coins[i]）。
 * 凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
 * 那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数
 * 那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数
 * 那么钱币有顺序和没有顺序都可以，都不影响钱币的最小个数
 * 而本题是要求最少硬币数量，硬币是组合数还是排列数都无所谓！所以两个for循环先后顺序怎样都可以！
 */
public class CoinChange {
    //v1：稍微优化版回溯
    int res = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        if (coins.length == 0) {
            return -1;
        }
        dfs(coins, amount, 0);
        if (res == Integer.MAX_VALUE) {
            return -1;
        }
        return res;
    }

    public void dfs(int[] coins, int amount, int count) {
        if (amount == 0) {
            res = Math.min(res, count);
        }
        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                dfs(coins, amount - coins[i], count + 1);
            } else {
                return;
            }
        }
    }
    // v2：记忆版回溯

    int[] memo;

    public int coinChangeV2(int[] coins, int amount) {
        if (coins.length == 0) {
            return -1;
        }
        memo = new int[amount];

        return findWay(coins, amount);
    }

    // memo[n] 表示钱币n可以被换取的最少的硬币数，不能换取就为-1
    // findWay函数的目的是为了找到 amount数量的零钱可以兑换的最少硬币数量，返回其值int
    public int findWay(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        // 记忆化的处理，memo[n]用赋予了值，就不用继续下面的循环
        // 直接的返回memo[n] 的最优值
        // 自己只需要关心一层！
        if (memo[amount - 1] != 0) {
            return memo[amount - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            int res = findWay(coins, amount - coins[i]);
            if (res >= 0 && res < min) {
                min = res + 1; // 加1，是为了加上得到res结果的那个步骤中，兑换的一个硬币
            }
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

    //v3：动态规划
    public int coinChangeV3(int[] coins, int amount) {
        // 自底向上的动态规划
        if (coins.length == 0) {
            return -1;
        }
        int max = Integer.MAX_VALUE;
        // memo[n]的值： 表示的凑成总金额为n所需的最少的硬币个数
        int[] memo = new int[amount + 1];
        // 给memo赋初值，最多的硬币数就是全部使用面值1的硬币进行换
        // amount + 1 是不可能达到的换取数量，于是使用其进行填充
        Arrays.fill(memo, max);
        memo[0] = 0;
        for (int i = 0; i <= coins.length; i++) {
            for (int j = coins[i]; j < amount; j++) {
                if (memo[j - coins[i]] != max) {
                    // memo[i]有两种实现的方式，
                    // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                    // 另一种就是不包含，要兑换的硬币数是memo[i]
                    memo[i] = Math.min(memo[i], memo[i - coins[j]] + 1);
                }
            }
        }

        return memo[amount] == max ? -1 : memo[amount];
    }
}
