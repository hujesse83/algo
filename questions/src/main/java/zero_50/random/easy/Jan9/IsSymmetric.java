package zero_50.random.easy.Jan9;

import zero_50.random.TreeNode;

/**
 * @author jesse.hu
 * @date 2022/1/9 23:04
 * @LeetCodeNo 101
 * @Desc 查看本颗树 是否对称
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        return isSymmetricNode(root.left, root.right);
    }

    public boolean isSymmetricNode(TreeNode left, TreeNode right) {
        //判定左右节点和自身
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //此时才进入单层递归的逻辑，单层递归的逻辑就是处理 左右节点都不为空，且数值相同的情况。
        boolean outSide = isSymmetricNode(left.left, right.right);
        boolean inSide = isSymmetricNode(left.right, right.left);
        return outSide && inSide;
    }
}
