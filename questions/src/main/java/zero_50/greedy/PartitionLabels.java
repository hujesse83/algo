package zero_50.greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/27 18:10
 * S = "ababcbacadefegdehijhklij" 输出：[9,7,8] 解释： 划分结果为 "ababcbaca", "defegde", "hijhklij"。 每个字母最多出现在一个片段中。
 * LC 763
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i]-'a'] = i; // 记录最后一次出现的下标
        }
        System.out.println(Arrays.toString(edge));
        int index = 0;
        int last = -1;
        for (int i = 0; i <chars.length ; i++) {
            index = Math.max(index,edge[chars[i]-'a']);
            if (i==index){
                list.add(i-last);
                last = i;
            }
        }
        return list;
    }
}
