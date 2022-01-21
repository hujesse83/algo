package zero_50.random.easy.Jan11;

import java.util.BitSet;

/**
 * @author jesse.hu
 * @date 2022/1/11 09:29
 * @LeetCodeNo 136
 * @Desc: 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumber {
    /**
     * 1、交换律: a ^ b ^ c = a ^ c ^ b
     * 2、0 ^ n = n;
     * 3、n ^ n = 0;   异或操作
     * eg. 2 ^ 3 ^ 2 ^ 4 ^ 3= 2 ^ 2 ^ 3 ^ 3 ^ 4
     */
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums){
            ans ^=num;
        }
        return ans;
    }
}
