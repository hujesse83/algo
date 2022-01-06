package zero_50.random.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode 1.
 * 1、Use HashMap
 */

public class TwoSum {
    // 5ms
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // first iteration: add values as key and index as value tp hashmap
        for (int n = 0; n < nums.length; n++) {
            map.put(nums[n], n);
        }
        //second iteration: check if element add up
        for (int n = 0; n < nums.length; n++) {
            int complement = target - nums[n];
            // complement can't be nums[n] + nums[n]
            if (map.containsKey(complement) && map.get(complement) != n) {
                return new int[]{n, map.get(complement)};
            }
        }
        return null;
    }

    // 3ms
    public int[] twoSumV2(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    // 1ms 时间复杂度 O(N) N是数组中的元素数量
    // 空间复杂度 O(N)  开销为哈希表元素数量的开销
    public int[] twoSumV3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if (map.containsKey(target-nums[i])){
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
    //brute force. It seems like I never use brute force...
    // 内存100% 时间复杂度O(N^2)  空间复杂度O(1)
    public int[] twoSumV4(int[] nums, int target) {
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[] {i,j};
                }
            }
        }
        return new int[]{};
    }
}
