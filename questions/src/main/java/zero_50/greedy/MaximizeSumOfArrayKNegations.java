package zero_50.greedy;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author huJesse
 * @Date 2021/11/24 10:41
 * @Skill 很牛逼的地方在于  1、"输入如何按绝对值排序"
 * 2、 数组通过stream求和
 * LC 1005
 */
public class MaximizeSumOfArrayKNegations {
    public static int largestSumAfterKNegations(int[] nums, int k) {
        nums = Arrays.stream(nums).boxed().sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1)).mapToInt(Integer::valueOf).toArray();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
        }
        // 如果k还大于0
        if (k % 2 == 1) {
            nums[len - 1] = -nums[len - 1];
        }
        return Arrays.stream(nums).sum();
    }
}
