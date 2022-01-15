package zero_50.random.easy.Jan13;

/**
 * @author jesse.hu
 * @date 2022/1/13 17:26
 * @LeetCodeNo 190  star
 *
 * 与&：0&0=0 0&1=0 1&0=0 1&1=1
 * 或|：0|0=0 0|1=1 1|0=1 1|1=1
 * 异或^：0^0=0 0^1=1 1^0=1 1^1=0
 * 取反~：~1=0 ~0=1
 * 左移<<：左边的二进制位丢弃，右边补0
 * 右移>>：正数左补0，负数左补1，右边丢弃
 * 无符号左移<<<：左边的二进制位丢弃，右边补0
 * 无符号右移>>>：忽略符号位，空位都以0补齐
 */
public class ReverseBits {
    public static int reverseBits(int n) {
        int a=0;
        for(int i=0;i<=31;i++){
            a+=((1&(n>>i))<<(31-i));
        }
        return a;
    }
}
