package zero_50.random.easy.Jan11;

import zero_50.random.easy.Jan6.TwoSum;

/**
 * @author jesse.hu
 * @date 2022/1/11 10:51
 * @LeetCodeNo 在TwoSum的基础上 将数组变为了递增数组
 */
public class TwoSumII {

    // 使用O(N) 、 O(N) 的哈希做法.   但这样没使用到有序数组的性质
    public int[] twoSum(int[] numbers, int target) {
        return new TwoSum().twoSum(numbers,target);
    }

    // 方法一； 固定住一个数进行二分查找 .  时间复杂度O(n*logN)
    public int[] twoSumV2(int[] numbers, int target) {
        for (int i = 0;i<numbers.length;i++){
            int left = i+1;
            int right = numbers.length - 1;
            while (left<=right){
                int mid = left + (right-left) / 2;
                if(numbers[mid] > target - numbers[i]){
                    right = mid-1;
                }else if (numbers[mid] < target - numbers[i]){
                    left = mid + 1;
                }else{
                    return new int[]{i+1,mid+1};
                }
            }
        }
        return new int[]{-1,-1};
    }
    // 方法三、双指针. 时间复杂度为O(N) 空间复杂度为O(1)
    public int[] twoSumV3(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            int sum = numbers[low] + numbers[high];
            if (sum == target) {
                return new int[]{low + 1, high + 1};
            } else if (sum < target) {
                ++low;
            } else {
                --high;
            }
        }
        return new int[]{-1, -1};
    }
}
