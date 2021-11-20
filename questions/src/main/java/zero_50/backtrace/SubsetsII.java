package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/20 21:04
 * @Description 这也是取子集 ， 但这个version要求去重 LC90
 */
public class SubsetsII {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backTrace(nums, 0);
        return res;
    }

    public void backTrace(int[] nums, int index) {
        res.add(new ArrayList<>(item));
        for (int i = index; i < nums.length; i++) {
            // 去重
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            item.add(i);
            backTrace(nums, i + 1);
            item.remove(item.size() - 1);
        }
    }
}
