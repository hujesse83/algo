package zero_50.random.easy.Jan10;

import java.util.Arrays;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/10 11:32
 * @LeetCodeNo 119
 * @Desc 杨辉三角II. 求出第rowIndex行
 */
public class PascalTriangleII {
    // Method 1、DP
    //动态规划压缩维数的本质就是利用循环的先后差
    public static List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2;i < dp.length;i++){
            for(int j = i - 1;j > 0;j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }

    //Method 2、 利用杨辉三角I 的答案.
    public static void main(String[] args) {
        getRow(4);
    }
}
