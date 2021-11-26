package zero_50.greedy;

/**
 * @Author huJesse
 * @Date 2021/11/26 14:13
 * 情况一：如果gas的总和小于cost总和，那么无论从哪里出发，一定是跑不了一圈的
 * <p>
 * 情况二：rest[i] = gas[i]-cost[i]为一天剩下的油，i从0开始计算累加到最后一站，如果累加没有出现负数，说明从0出发，油就没有断过，那么0就是起点。
 * <p>
 * 情况三：如果累加的最小值是负数，汽车就要从非0节点出发，从后向前，看哪个节点能这个负数填平，能把这个负数填平的节点就是出发节点
 * <p>
 * case:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]   output : 3;
 * 其实我们直接简化题意 ： [-2,-2,-2,3,3] 在i地点得到油量为item[i]
 * 对于环的操作  (i+1) & gas.length
 */
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if (curSum < 0) {
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if (totalSum < 0) return -1;
        return index;
    }
    // 只要gas总量>cost总量 说明总能到达 只要选一个正数就可以了
}
