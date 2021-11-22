package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/20 21:17
 * @Description 这个英语单词意思是全排列 && 题目中nums中的数据都是不同的
 * LC 全排列
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backTrace(nums);
        return res;
    }

    public void backTrace(int[] nums) {
        if (item.size() == nums.length) {
            res.add(new ArrayList<>(item));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 重复元素判断
            if (item.contains(nums[i])) {
                continue;
            }
            item.add(nums[i]);
            backTrace(nums);
            item.remove(item.size() - 1);
        }
    }

}
