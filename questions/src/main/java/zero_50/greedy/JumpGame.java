package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/23 01:00
 * 不一定非要明确一次究竟跳几步，每次取最大的跳跃步数，这个就是可以跳跃的覆盖范围
 * LC55 好难啊
 * [2,3,1,1,4]
 * [3,2,1,0,4]
 *
 * ====贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }
        // 覆盖范围，初始覆盖范围应该是0，因为下面的迭代是从下标0开始的
        int coverRange = 0;
        for (int i = 0; i <=coverRange ; i++) {
            coverRange = Math.max(coverRange,i+nums[i]);
            if(coverRange>= nums.length-1){
                return true;
            }
        }
        return false;
    }
}
