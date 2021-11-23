package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/23 00:15
 * /** LC53
 * 如果count一旦加上nums[i]变为负数，那么就应该从nums[i+1]开始从0累积count了，因为已经变为负数的count，只会拖累总和
 */
public class MaximumSubArray {
    // 贪心算法  局部最优
    public static int maxSubArray(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i <nums.length ; i++) {
            count+=nums[i];
            sum = Math.max(sum,count);
            if (count<0){
                count = 0;
            }
        }
        return  sum;
    }

    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-7,4};
        MaximumSubArray.maxSubArray(nums);
    }
}
