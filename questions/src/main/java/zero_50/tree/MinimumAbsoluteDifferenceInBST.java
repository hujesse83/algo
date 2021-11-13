package zero_50.tree;

/**
 * @Time 2021/11/14 02:06
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 * LC 530
 */
public class MinimumAbsoluteDifferenceInBST {
    public int prev = -1;
    public int minDiff = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }
    public void dfs(TreeNode root){
        if(root==null){
            return;
        }
        dfs(root.left);
        if (prev>=0){
            minDiff = Math.min(minDiff, root.val-prev);
        }
        prev = root.val;
        dfs(root.right);
    }

}
