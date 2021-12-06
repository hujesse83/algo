package zero_50.dp;

/**
 * @Author huJesse
 * @Date 2021/12/6 16:26
 * 本题中strs 数组里的元素就是物品，每个物品都是一个！
 * 而m 和 n相当于是一个背包，两个维度的背包。
 * 对于重量而言 这是多维的01背包
 * LC 474
 */
public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1]; //1、dp数组下标含义：最多有i个0和j个1的strs的最大子集的大小为dp[i][j]。
        //2、 确定递推公式 dp[i][j] 可以由前一个strs里的字符串推导出来
        //dp[i][j] = max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
        int oneSum, zeroSum;
        for (String str : strs) {
            oneSum = 0;
            zeroSum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroSum++;
                } else {
                    oneSum++;
                }
            }
            for (int i = m; i >= zeroSum; i--) {
                for (int j = n; j >= oneSum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroSum][j - oneSum] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String[] list = {"10", "0001", "111001", "1", "0"};
        System.out.println(new OnesAndZeroes().findMaxForm(list, 5, 4));
    }
}
