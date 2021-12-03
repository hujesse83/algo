package zero_50.dp;

import java.util.Arrays;

/**
 * LC 62 不同路径
 * @Author huJesse
 * @Date 2021/12/3 12:30
 * 方法：dp
 */
public class UniquePathsDp {
    public int uniquePaths(int m, int n) {
        int [][]dp = new int[m][n];  // dp代表棋盘格,每个格子代表从(0,0)到dp[i][j]的路径次数
        Arrays.fill(dp[0],1);
        for (int i = 0; i <m ; i++) {
            dp[i][0] = 1;
        }
        // dp[i][j] = dp[i-1][j] + dp[i][j-1]
        for (int i = 1; i <m ; i++) {
            for (int j =1 ; j <n ; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }

    // 滚动数组 一维数组替代二维数组
    public int uniquePathsV2(int m,int n){
        int []dp = new int[n];
        Arrays.fill(dp,1);
        for (int i = 1; i <m ; i++) {
            for (int j = 1; j <n ; j++) {
                dp[j] +=dp[j-1];
            }
        }
        return dp[n-1];
    }

    // V3 数独方法 走到终点都需要 m + n - 2 步
    //在这m + n - 2 步中，一定有 m - 1 步是要向下走的，不用管什么时候向下走。
    //那么有几种走法呢？ 可以转化为，给你m + n - 2个不同的数，随便取m - 1个数，有几种取法。
}
