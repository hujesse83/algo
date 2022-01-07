package zero_50.random.easy.Jan7;

/**
 * @author jesse.hu
 * @date 2022/1/7 13:49
 * @LeetCodeNo 35
 * 给定一个排序数组和一个目标值，在数字中找到目标值，并返回其索引
 * 如果目标值不存在与数组中，返回他将会被按顺序插入的位置
 * 无重复元素
 * You must write an algorithm with O(log n) runtime complexity.
 * 二分查找 递归与非递归都有实现
 * 二分查找 拓展： 在一个有序数组中，由多个相同的值时，如何将所有的数值都找到，而不是返回其中一个
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // 定义target在左闭右闭的区间，[low, high]
        int low = 0;
        int high = n - 1;

        while (low <= high) { // 当low==high，区间[low, high]依然有效
            int mid = low + (high - low) / 2; // 防止溢出
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return low;
    }

    // 递归版本
    public static int searchInsertV2(int[] nums, int target) {
        return binarySearch(nums,target,0,nums.length-1);
    }

    public static int binarySearch(int []arr,int target,int left,int right){
        while (left <=right){
            int mid = left + (right-left)/2;
            if (arr[mid] > target){
                return binarySearch(arr,target,left,mid-1);
            }else if (arr[mid] < target){
                return binarySearch(arr,target,mid+1,right);
            }else{
                return mid;
            }
        }
        return left;
    }



    public static void main(String[] args) {
        searchInsertV2(new int[]{1, 3, 5, 6}, 7);
    }
}
