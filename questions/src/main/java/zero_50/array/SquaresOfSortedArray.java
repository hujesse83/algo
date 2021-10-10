package zero_50.array;

import java.util.Arrays;

/**
 * No977
 * 那么数组平方的最大值就在数组的两端，不是最左边就是最右边，不可能是中间。
 * 此时可以考虑双指针法了，i指向起始位置，j指向终止位置
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        int []nums = {-4,-1,0,3,10};
        int[] ints = sortedSquaresV2(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 垃圾代码 平方后再排序
     */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i]*=nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
    /**
     * 双指针
     */
    public static int[] sortedSquaresV2(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        int []res  = new int[nums.length];
        int index = nums.length-1;
        while (i<=j){
            if (nums[i]*nums[i]<nums[j]*nums[j]){
                res[index--] = nums[j]*nums[j];
                j--;
            }else {
                res[index--] = nums[i]*nums[i];
                i++;
            }
        }
        return res;
    }

}
