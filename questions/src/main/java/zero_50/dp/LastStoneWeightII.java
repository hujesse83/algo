package zero_50.dp;

import java.util.Arrays;

/**
 * @Author huJesse
 * @Date 2021/12/5 15:26
 * @Description 这种题也能转换为01背包问题  妙啊我是废物 LC 1049
 * 本题其实就是尽量让石头分成重量相同的两堆，相撞之后剩下的石头最小，这样就化解成01背包问题了
 */
public class LastStoneWeightII {
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int midSum = sum >> 1; //右移一位 除2
        int[] dp = new int[midSum + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = midSum; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return sum - (dp[midSum] << 1);
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(new LastStoneWeightII().lastStoneWeightII(stones));
    }
}
