package zero_50;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 第一题
 * 1) 暴力穷尽法
 * 2）排序 + 头尾双指针寻找  但是排序之后顺序会变
 * 3) dp 写不出来
 * 4） hashmap ok 是用数组作为哈希表来解决哈希问题
 */

public class TwoSum {
    public static void main(String[] args) {
        int[] array = {3, 2, 4, 6};
        int target = 6;
        int[] ints = twoSum(array, target);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * hashmap 以空间换时间
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indices[0] = i;
                indices[1] = hash.get(nums[i]);
                return indices;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        // // 双重循环 循环极限为(n^2-n)/2
        // for(int i = 0; i < nums.length; i++){
        //     for(int j = nums.length - 1; j > i; j --){
        //         if(nums[i]+nums[j] == target){
        //            indexs[0] = i;
        //            indexs[1] = j;
        //            return indexs;
        //         }
        //     }
        // }
        return indices;
    }

}
