package zero_50.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/16 21:19
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 难点在于去重..
 */
public class CombinationSumII {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        if (candidates.length==0){
            return res;
        }
        backTrace(candidates,target,0);
        return res;
    }
    public void backTrace(int []candidates,int target,int index){
        if (target==0){
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = index; i <candidates.length ; i++) {
            if (target-candidates[i]<0){
                return;
            }
            item.add(candidates[i]);
            // 很难的地方在于如何去重... 保证本层不重复（） 结合树状图联想
            if (i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            backTrace(candidates,target-candidates[i],i+1);
            item.remove(item.size()-1);
        }
    }
}
