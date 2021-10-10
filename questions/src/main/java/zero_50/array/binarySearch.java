package zero_50.array;

// 二分查找 并不陌生不多说了 No704
public class binarySearch {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 3, 5, 9, 12};
        System.out.println(searchV2(arr, 0,arr.length-1,19));
    }

    /**
     * 非递归  对于二分 我存在疑惑的点在于mid 这里定义mid在左区间中最后一个元素， 表示为： Arr = [left,mid],(mid,right]；
     */
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (target > nums[nums.length - 1] || target < nums[0]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        int mid ;
        while (left <= right) {
            mid = left + (right - left) >> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    /**,
     * recursion 但是leetCode上面好像并不支持增加参数
     */
    // Arr = [left,mid],(mid,right]；
    public static int searchV2(int[] nums, int left ,int right, int target) {
        if (left>right){
            return -1;
        }
        int mid = left+ (right-left)/2;
        if (nums[mid]>target){
            return searchV2(nums,left,mid-1,target);
        }else if (nums[mid]<target){
            return searchV2(nums,mid+1,right,target);
        }else {
            return mid;
        }
    }

}
