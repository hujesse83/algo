package zero_50.dp;

/**
 * @Author huJesse
 * @Date 2021/12/3 16:05
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * Catalan数列
 * dp[3] = dp[2] * dp[0] + dp[1] * dp[1] + dp[0] * dp[2]
 * 找动态方程还真挺难的
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                //对于第i个节点，需要考虑1作为根节点直到i作为根节点的情况，所以需要累加
                //一共i个节点，对于根节点j时,左子树的节点个数为j-1，右子树的节点个数为i-j
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
