package zero_50.random.easy.Jan10;

import zero_50.random.TreeNode;

/**
 * @author jesse.hu
 * @date 2022/1/10 10:19
 * @LeetCodeNo 110
 * @Desc 判断一棵树是不是平衡二叉树 :star 错了好几遍了
 */
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
        if (leftHeight == -1 || rightHeight==-1 || Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;
    }
}
