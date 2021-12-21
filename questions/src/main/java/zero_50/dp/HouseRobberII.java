package zero_50.dp;

/**
 * 在打家劫舍的基础上增加了环、首位不能相连
 * 分为三种情况：
 *      2、考虑包含首位元素，不包含尾元素.
 *      3、考虑包含尾元素，不包含首元素.
 * 其实就是把环拆成两个队列，一个是从0到n-1，另一个是从1到n，然后返回两个结果最大的。
 * LC 213.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length==1){
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums,0,length-1),robRange(nums,1,length));

    }
    public int robRange(int []nums,int start,int end){
        int first = nums[start];
        int second = Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <end ; i++) {
            int temp = second;
            second = Math.max(first+nums[i],temp);
            first = temp;
        }
        return second;
    }
}
