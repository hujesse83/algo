package zero_50.tree;

/**
 * @Time 2021/11/7  13:37
 * LC 110
 */

/**
 * 老问题：
 * 我们先来看看高度和深度的定义，某节点的深度是指从根节点到该节点的最长简单节点的个数，而高度是指从该节点到叶子节点的最长节点的个数。
 */
//平衡二叉树也就是左子树为平衡二叉树并且右子树也是平衡二叉树同时左右子树高度不大于1
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
       return height(root)!=-1;
    }
    public int height(TreeNode node){
        if (node==null){
            return 0;
        }
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        if (leftHeight>=0 && rightHeight>=0 && Math.abs(leftHeight-rightHeight)<=1){
            return Math.max(leftHeight,rightHeight)+1;
        }else {
            return -1;
        }
    }
}
