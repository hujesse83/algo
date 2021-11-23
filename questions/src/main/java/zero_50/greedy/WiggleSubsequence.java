package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/23 00:03
 * LC 376
 */
public class WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int curDiff = 0;
        int preDiff = 0;
        int count  = 1;
        for (int i = 1; i <nums.length ; i++) {
            curDiff = nums[i] - nums[i-1];
            if (curDiff>0 && preDiff<=0 || curDiff<0&&preDiff>=0){
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
    // 化简成判断连续上升或者下降的波段个数
    public int wiggleMaxLengthV2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int up = 1;
        int down = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1;
            }
            if (nums[i] < nums[i - 1]) {
                down = up + 1;
            }
        }
        return Math.max(up, down);
    }

}
