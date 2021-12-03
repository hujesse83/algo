package zero_50.dp;

/**
 * @Author huJesse
 * @Date 2021/12/3 15:00
 * LC 343 awesome
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 */
public class IntegerBreak {
    // 1、dp
    public int integerBreak(int n) {
        //1、确定dp数组以及下标的含义 : 拆分数字i可以得到最大乘积为dp[i];
        // j 表示[1,i-1] 中的数字
        //2、确定递推公示，dp[i] = max(dp[i], max((i - j) * j, dp[i - j] * j));
        int []dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <=n ; i++) {
            for (int j = 1; j <=i-1 ; j++) {
                //j*(i-j)代表把i拆分为j和i-j两个数相乘
                //j*dp[i-j]代表把i拆分成j和继续把(i-j)这个数拆分，取(i-j)拆分结果中的最大乘积与j相乘
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }
    //2、数学推导

    /**
     * 数学方法，求函数y=(n/x)^x(x>0)的最大值，可得x=e时y最大，但只能分解成整数，
     * 故x取2或3，由于6=2+2+2=3+3，显然2^3=8<9=3^2,故应分解为多个3
     */
    public int integerBreakV2(int n){
        if (n==2){
            return 1;
        }
        if (n==3){
            return 2;
        }
        int a =1;
        while (n>4){
            n = n-3;
            a = a * 3;
        }
        return a * n;
    }
}
