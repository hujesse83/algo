package zero_50.dp;

/**
 * 对于背包问题其实状态都是可以压缩的 此类将01背包压缩为一维数组
 * 在一维dp数组中，dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
 * @Author huJesse
 * @Date 2021/12/4 15:32
 */
public class BaseTheory01V2 {
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
        int []dp = new int[col];
        for (int i = weight[0]; i <=bagSize ; i++) {
            dp[i] = value[0];
        }
        // 以上为一维数组的初始化
        for (int i = 1; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if (j>=weight[i]){
                    dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
                }
            }
        }
        System.out.println(dp[bagSize]);
    }
}
