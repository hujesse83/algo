package zero_50.backtrace;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author huJesse
 * @Date 2021/11/20 20:44
 * @Description 求子集问题 可以抽象为求树的节点 LC78
 */
public class Subsets {
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> item = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrace(nums, 0);
        return res;
    }

    public void backTrace(int[] nums, int index) {
        res.add(item);
        for (int i = index; i < nums.length; i++) {
            item.add(i);
            backTrace(nums, i + 1);
            item.remove(item.size() - 1);
        }
    }


}
