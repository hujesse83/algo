package zero_50.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author huJesse
 * @Date 2021/11/27 15:43
 * @Description 本题有两个维度，h和k，看到这种题目一定要想如何确定一个维度，然后在按照另一个维度重新排列
 * 本题有两个维度，h和k，看到这种题目一定要想如何确定一个维度，然后在按照另一个维度重新排列。
 * LC 406
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        // 身高从大到小排（身高相同k小的站前面
        Arrays.sort(people,(a,b)->{
            if (a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        // ArrayList 插入时间复杂度很高
        LinkedList<int []> list = new LinkedList<>();
        for (int[] person : people) {
            list.add(person[1],person);
        }
        return list.toArray(new int[people.length][]);
    }
}
