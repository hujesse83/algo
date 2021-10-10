package zero_50.useHash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * 349
 * 输出结果中的每个元素一定是唯一的，也就是说输出的结果的去重的， 同时可以不考虑输出结果的顺序
 * 注意：set 不仅占用空间比数组大，而且速度要比数组慢，set把数值映射到key上都要做hash计算的。
 */
public class IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int []nums1 = {1,2,2,1};
        int []nums2 = {2,2};
        int[] intersection = intersection(nums1, nums2);
        System.out.println(Arrays.toString(intersection));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int item : nums1) {
            set.add(item);
        }
        // 这儿与别人的答案相比 我只用了一个Set  去掉set中元素是关键
        for (int item : nums2) {
            if (set.contains(item)){
                list.add(item);
                set.remove(item);
            }
        }
        int []res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
