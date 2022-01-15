package zero_50.random.easy.Jan13;

/**
 * @author jesse.hu
 * @date 2022/1/13 18:12
 * @LeetCodeNo 191
 * bit 位上有几个1
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int ans=0;
        for (int i = 0;i<32;i++){
            ans += 1 & (n>>i);
        }
        return ans;
    }
}
