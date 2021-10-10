package zero_50.useHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No 15.
 * 拿这个nums数组来举例，首先将数组排序，然后有一层for循环，i从下标0的地方开始，同时定一个下标left 定义在i+1的位置上，定义下标right 在数组结尾的位置上。
 * <p>
 * 依然还是在数组中找到 abc 使得a + b +c =0，我们这里相当于 a = nums[i] b = nums[left] c = nums[right]。
 * <p>
 * 接下来如何移动left 和right呢， 如果nums[i] + nums[left] + nums[right] > 0 就说明 此时三数之和大了，因为数组是排序后了，所以right下标就应该向左移动，这样才能让三数之和小一些。
 * <p>
 * 如果 nums[i] + nums[left] + nums[right] < 0 说明 此时 三数之和小了，left 就向右移动，才能让三数之和大一些，直到left与right相遇为止。
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-4, -1, -1, 0, 1, 2};
        System.out.println(threeSum(nums));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            // 最小值大于0
            if (nums[i]>0){
                return list;
            }
            //去重的条件之一 比如上面的{-1,-1,0,1} 会造成重复的结果
            if (i>0 && nums[i]==nums[i-1]){
                continue;
            }
            int left = i+1;
            int right = nums.length-1;
            while(right>left){
                if (nums[i]+nums[left]+nums[right]>0){
                    right--;
                }else if (nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else {
                    list.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    /* 这段代码用来判断中间是否是重复的*/
                    while (right>left && nums[left]==nums[left+1]) left++;
                    while (right>left && nums[right]==nums[right-1]) right--;
                    right--;
                    left++;
                }
            }
        }
        return list;
    }
}
