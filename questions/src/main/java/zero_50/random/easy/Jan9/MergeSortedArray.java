package zero_50.random.easy.Jan9;

import java.util.Arrays;

/**
 * @author jesse.hu
 * @date 2022/1/9 22:18
 * @LeetCodeNo 88
 * @Desc : 合并二个递增数列。
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，
 * 另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 */
public class MergeSortedArray {
    // 先合并、再排序
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = 0;
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[index++];
        }
        Arrays.sort(nums1);
    }

    // 二、双指针
    public static void mergeV2(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int p1 = 0;
        int p2 = 0;
        int index = 0;
        while (p1 < m || p2 < n) {
            if (p1 == m) {
                res[index] = nums2[p2++];
            } else if (p2 == n) {
                res[index] = nums1[p1++];
            } else if (nums1[p1] < nums2[p2]) {
                res[index] = nums1[p1++];
            } else {
                res[index] = nums2[p2++];
            }
            index++;
        }
        for (int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    public static void main(String[] args) {
        mergeV2(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }
}
