package zero_50;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 第一题
 * 1) 暴力穷尽法
 * 2）排序 + 头尾双指针寻找  但是排序之后顺序会变
 * 3) dp 写不出来
 * 4） hashmap ok
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
    public static int[] twoSum(int[] array, int target) {
        int[] indices = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                indices[1] = i;
                indices[0] = map.get(array[i]);
                break;
            } else {
                // 将数据存入 key为补数 ，value为下标
                map.put(target - array[i], i);
            }
        }
        return indices;
    }

}
