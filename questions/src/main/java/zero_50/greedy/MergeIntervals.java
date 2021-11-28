package zero_50.greedy;

import java.util.*;

/**
 * @Author huJesse
 * @Date 2021/11/28 13:36
 * @Description 合并重叠的区间
 * 按照左边界排序，排序之后局部最优：每次合并都取最大的右边界，这样就可以合并更多的区间了
 * LC 56
 */
public class MergeIntervals {
    // v1:当时卡在了第0个元素加不进去的情况
    public int[][] merge(int[][] intervals) {
        List<int []> res = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o->o[0])); // 根据intervals[0]排序
        for (int i = 1; i <intervals.length ; i++) {
            if (intervals[i][0]<=intervals[i-1][1]){
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i][1],intervals[i-1][1]);
            }else {
                res.add(intervals[i-1]);
            }
        }
        res.add(intervals[intervals.length-1]);
        return res.toArray(new int[res.size()][]);
    }
    // v2：大佬的bitmap
    public static int[][] mergeV2(int[][] intervals) {
        BitSet set = new BitSet();
        int max = 0;
        for(int[] interval : intervals){
            int left = interval[0] * 2;
            int right = interval[1] * 2 + 1;
            set.set(left, right, true);
            max = max < right ? right : max;
        }
        int start = 0;
        int end = 0;
        int count = 0;
        while(end < max){
            start = set.nextSetBit(end);
            end = set.nextClearBit(start);
            intervals[count][0] = start / 2;
            intervals[count][1] = (end - 1) / 2;
            count++;
        }
        int[][] res = new int[count][2];
        for(int i = 0; i < count; i++){
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        return res;
    }
}
