package zero_50.dp;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/8 15:57
 */
public class BaseTheoryFullPackage {
    public static void main(String[] args) {
        int []weight = {1,3,4};
        int []value = {15,20,30};
        int bagWeight = 4;
        int []dp = new int[bagWeight+1];
        //而完全背包的物品是可以添加多次的，所以要从小到大去遍历，即：
        // 先遍历物品，再遍历背包
        for(int i = 0; i < weight.length; i++) { // 遍历物品
            for(int j = weight[i]; j <= bagWeight ; j++) { // 遍历背包容量
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));

    }
}
