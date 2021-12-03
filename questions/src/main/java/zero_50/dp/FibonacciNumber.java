package zero_50.dp;

/**
 * @Author huJesse
 * @Date 2021/12/2 16:34
 * LC 509
 */
public class FibonacciNumber {
    // 1、recursion 会做许多到无用功
    public int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }
    //2、简单的dp 甚至还没有感觉用到了dp.. 但确实是dynamic的
    public int fibDp(int n){
        if (n==0 || n == 1){
            return n;
        }
        int []dp = new int[n+1]; //1、确定dp数组以及dp[i]的定义为：第i个数的斐波那契数值是dp[i]
        dp[0] = 0;//3、dp数组初始化
        dp[1] = 1;
        for (int i = 2; i <=n ; i++) {
            dp[i] = dp[i-1]+dp[i-2];//2、确定递推公示
        }
        return dp[dp.length-1];
    }
    //3、滚动数组的思想
    public int fibVar(int n){
        if (n<2){
            return n;
        }
        int p = 0,q=1,r=1;
        for (int i = 2; i <=n ; i++) {
            r = p +q ;
            p = q;
            q = r;
        }
        return r;
    }
    //4 dp升级版本 和滚动数组一样的
    public int fibV2(int N) {
        if (N <= 1) return N;
        int dp[] = new int[2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
