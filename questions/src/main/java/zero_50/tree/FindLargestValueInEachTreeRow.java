package zero_50.tree;

import java.util.LinkedList;
import java.util.List;

/**
 * LC515  找每层最大值
 */
public class FindLargestValueInEachTreeRow {
    public static List<Integer> result = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root,0);
        return result;
    }
    public static void dfs(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;
        //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
        if (result.size()<deep){
            result.add(Integer.MIN_VALUE);
        }
        result.set(deep-1,Math.max(result.get(deep-1),node.val));
        dfs(node.left, deep);
        dfs(node.right, deep);
    }
}
