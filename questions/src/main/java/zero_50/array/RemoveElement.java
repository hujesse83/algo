package zero_50.array;

/**
 * NO 27
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 */

public class RemoveElement {
    public static void main(String[] args) {
        int []nums = {0,0,1,2,2,2,3,4,5,6,7};
        System.out.println(removeElementV2(nums, 0));
    }

    /**
     * 方法一：快慢指针
     */
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != val) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }
    /**
     * 方法二 bf
     */
    public static int removeElementV2(int []nums,int val){
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i]==val){
                for (int j = i+1; j <size ; j++) {
                    nums[j-1] = nums[j];
                }
                i--;
                size--;
            }
        }
        return size;
    }


}
