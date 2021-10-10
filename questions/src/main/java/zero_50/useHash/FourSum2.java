package zero_50.useHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 哈希总结：
 * 常见的三种哈希结构：
 * 数组
 * set（集合）
 * map（映射）
 */
public class FourSum2 {
    public static void main(String[] args) {
        int []num ={-2,-1,0,0,1,2};
        int []num2 ={2,2,2,2};
        int []num3 ={-5,-4,-3,-2,1,3,3,5};

        System.out.println(fourSum(num3, -11));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            // 下面的判断让我吃了亏 这与三数之和判断0不一样
            /*
            if (nums[i]>target){
                return list;
            }
             */
            if (i>0 &&nums[i]==nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left = j+1;
                int right = nums.length-1;
                while (right>left){
                    if (nums[i]+nums[j]+nums[left]<target-nums[right]){
                        left++;
                    }else if (nums[i]+nums[j]+nums[left]>target-nums[right]){
                        right--;
                    }else {
                        list.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (right>left && nums[right]==nums[right-1]) right--;
                        while (right>left && nums[left]==nums[left+1]) left++;
                        left++;
                        right--;
                    }
                }
            }
        }
        return list;
    }
}
