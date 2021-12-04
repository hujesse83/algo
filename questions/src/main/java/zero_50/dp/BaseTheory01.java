package zero_50.dp;

import java.util.Arrays;

/**
 * BaseTheory01 使用的dp数组为二维数组
 * @Author huJesse
 * @Date 2021/12/4 15:15
 * @Description  最重要的点在与弄懂dp数组以及下标的含义了
 *              dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
 *              dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
 *              dp[i][j] 表示从下标为[0-i]的物品里任意取，放进容量为j的背包，价值总和最大是多少。
 *              [0, 15, 15, 15, 15]
 *              [0, 15, 15, 20, 35]
 *              [0, 15, 15, 20, 35]
 */
public class BaseTheory01 {
    public static void main(String[] args) {
        int []weight = {1,3,4};
        int []value = {15,20,30};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);
    }
    public static void testWeightBagProblem(int []weight,int []value,int bagSize){
        // weight数组的大小 就是物品个数
        int row = weight.length;
        int col = bagSize+1;
        int [][]dp = new int[row][col];
        // 初始化dp数组物品0
        for (int i = weight[0]; i <=bagSize ; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i <row ; i++) { // 遍历物品
            for (int j = 0; j <col ; j++) {  // 遍历背包容量
                if (j<weight[i]){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j- weight[i]]+value[i]);
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
