package zero_50.random.easy.Jan10;

import zero_50.random.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/10 10:48
 * @LeetCodeNo 112
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root==null){
            return false;
        }
        if (root.left ==null && root.right==null){
            return root.val == targetSum;
        }
        List<List<Integer>> res= new ArrayList<>();
        boolean isLeft = hasPathSum(root.left,targetSum-root.val);
        boolean isRight = hasPathSum(root.right,targetSum-root.val);
        return isLeft || isRight;
    }
}
