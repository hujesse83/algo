package zero_50.dp;
/**
 * LC 746
 * 我觉得这个题的描述应该改改：每个阶梯都有一定数量坨屎，一次只能跨一个或者两个阶梯，走到一个阶梯就要吃光上面的屎，问怎么走才能吃最少的屎？
 * 开局你选前两个阶梯的其中一个作为开头点，并吃光该阶梯的屎。
 * @Author huJesse
 * @Date 2021/12/3 09:34
 * @步骤 1、确定dp数组以及下标的含义  到达第i个台阶所花费的最少体力为dp[i]。
 * 2、确定递推公式  可以有两个途径得到dp[i]，一个是dp[i-1] 一个是dp[i-2]。
 * 3、dp数组如何初始化
 * 4、确定遍历顺序
 * 5、举例推导dp数组
 */
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len <= 1) {
            return cost[0];
        }
        int[] dp = new int[len]; //dp[i]表示达到第i个台阶所花费的最少体力值dp[i]
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        return Math.min(dp[len - 1], dp[len - 2]);
    }
    // 精简
    public int minCostClimbingStairsV2(int []cost){
        int len = cost.length;
        if (len <= 1) {
            return cost[0];
        }
        int []dp = new int[2];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int dpi = Math.min(dp[0],dp[1])+cost[i];
            dp[0] = dp[1];
            dp[1] = dpi;
        }
        return Math.min(dp[0],dp[1]);
    }
}
