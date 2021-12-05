package zero_50.dp;

import java.util.Arrays;

/**
 * 对于背包问题其实状态都是可以压缩的 此类将01背包压缩为一维数组
 * 在一维dp数组中，dp[j]表示：容量为j的背包，所背的物品价值可以最大为dp[j]。
 * @Author huJesse
 * @Date 2021/12/4 15:32
 * Bug occurred .. 不能从前往后遍历 会导致一个值出现二次的错误情况
 * Bug occurred .. 不能从前往后遍历 会导致一个值出现二次的错误情况
 * Bug occurred .. 不能从前往后遍历 会导致一个值出现二次的错误情况 因为dp[j - weight[i]]会往前找，而我们从前往后会更新前面的值。
 *
 * bug fixed .. 17:16
 */
public class BaseTheory01V2 {
    public static void main(String[] args) {
        int []weight = {1,2,5};
        int []value = {1,2,5};
        int bagSize = 4;
        testWeightBagProblem(weight,value,bagSize);

    }
    public static void testWeightBagProblem(int []weight,int []value,int bagSize){
        // weight数组的大小 就是物品个数
        int row = weight.length;
        int col = bagSize+1;
        int []dp = new int[col];
        for(int i = 0; i < row; i++) { // 遍历物品
            for(int j = bagSize; j >= weight[i]; j--) { // 遍历背包容量
                // 对于这个递推公式，发现自己理解得还不够透彻。
                // 意思是dp[j] = 不加入背包的价值 与 加入了背包之后 （物品的价值 + 剩余空间背包最大价值）的比较
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
