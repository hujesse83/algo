package zero_50.dp;
/**
 * LC 63
 * @Author huJesse
 * @Date 2021/12/3 14:10
 * @Description 在寻找路径的基础上增加了障碍.
 */
public class UniquePathII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) break; //一旦遇到障碍，后续都到不了
            dp[0][i] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) break; ////一旦遇到障碍，后续都到不了
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
