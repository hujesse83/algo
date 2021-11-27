package zero_50.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author huJesse
 * @Date 2021/11/27 16:55
 * @Description 总结为区间分割问题。LC452
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        // 排序后为 [[1,6],[2,8],[7,12],[10,16]]
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));  // sonar给我替代的排序方案
        int count = 1;
        for (int i = 1; i < points.length ; i++) {
            if (points[i][0]>points[i-1][1]){
             count++;
            }else {
                points[i][1] = Math.min(points[i-1][1],points[i][1]);  // 避免[[1,2],[1,4]] 后面长度要长一些。
            }
        }
        return count;
    }

}
