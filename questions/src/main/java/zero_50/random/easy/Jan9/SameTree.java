package zero_50.random.easy.Jan9;

import zero_50.random.TreeNode;

/**
 * @author jesse.hu
 * @date 2022/1/9 22:54
 * @LeetCodeNo 100
 * @Desc 相同的树
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);
        return isLeft && isRight;
    }
}
