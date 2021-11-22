package zero_50.backtrace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/20 21:32
 * @Description 题目中nums中的数据有相同的 LC47 去重为关键啊
 * link ： https://programmercarl.com/0047.%E5%85%A8%E6%8E%92%E5%88%97II.html#%E6%8B%93%E5%B1%95
 * 上面讲述了去重 以[1,1,1]图解 一目了然
 * LC 47
 */
public class PermutationsII {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();
    // used数组
    int[] usedArray;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        usedArray = new int[nums.length];
        backTrace(nums);
        return res;
    }

    public void backTrace(int[] nums) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 去重 精华
            if (i > 0 && usedArray[i - 1] == 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            if (usedArray[i]==1){
                continue;
            }
            item.add(nums[i]);
            usedArray[i] = 1;
            backTrace(nums);
            item.remove(item.size() - 1);
            usedArray[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }

}
