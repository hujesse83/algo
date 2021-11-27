package zero_50.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author huJesse
 * @Date 2021/11/27 17:25
 * v1:按照左边界排序，就要从右向左遍历，因为左边界数值越大越好（越靠右），这样就给前一个区间的空间就越大，所以可以从右向左遍历。
 * v2:按照右边界排序，就要从左向右遍历，因为右边界越小越好，只要右边界越小，留给下一个区间的空间就越大，所以从左向右遍历，优先选右边界小的。
 * v3:其实不用按照右边界进行排序，直接按照打气球那一题，箭的个数就是不重叠区间的个数，那么重叠区间的个数就是总长度减去不重叠区间的个数，只需要修改最后的返回值即可
 */
public class NoneOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        //[[1,2],[1,3],[2,3],[3,4]]  ==>1
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        for (int[] interval : intervals) {
            System.out.println(Arrays.toString(interval));
        }
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                count++;
                intervals[i][1] = intervals[i - 1][1];
            }

        }
        return count;
    }
}
