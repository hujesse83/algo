package zero_50.random.easy.Jan7;

/**
 * @author jesse.hu
 * @date 2022/1/7 11:33
 * @LeetCodeNo 27
 * @Desc 同样也是双指针的应用
 * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
 * 输出：5, nums = [0,1,4,0,3]
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int slow = 0;
        for(int fast = 0;fast<len;fast++){
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
