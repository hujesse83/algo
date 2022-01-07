package zero_50.random.easy.Jan7;

/**
 * @author jesse.hu
 * @date 2022/1/7 10:57
 * @LeetCodeNo 26
 * @Desc 删除排序数组中的重复想项目. 要求原地删除. 不能新建空间
 * 模式识别：需要保存可覆盖位置和观测位置, 利用双指针
 */
public class RemoveDuplicatesFromSortedArray {
    /**
     * i 为慢指针，指向答案位置
     * j 为快指针，用来扫描
     */
    // 双指针
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len<2){
            return len;
        }
        int i = 0;
        for (int j=1;j<len;j++){
            if (nums[j]!=nums[i]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
}
