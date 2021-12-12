package zero_50.dp.multiplePackage;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author huJesse
 * @Date 2021/12/12 21:48
 * 多重背包概述：有N种物品和一个容量为V 的背包。第i种物品最多有Mi件可用，每件耗费的空间是Ci ，价值是Wi 。
 * 求解将哪些物品装入背包可使这些物品的耗费的空间 总和不超过背包容量，且价值总和最大。
 * 基本面试不会出现，LeetCode上面也没有
 * ==> 转换为01背包问题：第i件物品可以用Mi次，那就把Mi次摊开。例如一个物品用二次{1}=>{1,1}
 */
public class BaseTheory {
    public static void main(String[] args) {
        /**
         * 这里注意：Array.asList(T..) 转的list不能add,remove操作
         */
        List<Integer> weight = Stream.of(1, 3, 4).collect(Collectors.toList());
        List<Integer> value = Stream.of(15, 20, 30).collect(Collectors.toList());
        int[] nums = {2, 3, 2};
        int bagWeight = 10;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 1) {
                weight.add(weight.get(i));
                value.add(value.get(i));
                nums[i]--;
            }
        }
        int[] dp = new int[bagWeight + 1];
        for (int i = 0; i < weight.size(); i++) {  // 遍历物品
            for (int j = bagWeight; j >= weight.get(i); j--) {  // 01背包是从后往前遍历，这样不会重复使用某个物品
                dp[j] = Math.max(dp[j], dp[j - weight.get(i)] + value.get(i));
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
