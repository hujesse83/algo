package zero_50.random.easy.Jan10;

import zero_50.random.TreeNode;

/**
 * @author jesse.hu
 * @date 2022/1/10 10:34
 * @LeetCodeNo 111
 * Given a binary tree, find its minimum depth.
 * @Key 我们需要一个变量记录最小深度 :star
 */
public class MinimumDepthOfBinaryTree {
    // 时间复杂度O(N),其中N是树的节点数。对每个节点访问一次
    // 空间复杂度 O(H),H是树的高度、最坏情况下，树呈链状.  正常情况下为O(logN)
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth(root.right), min_depth);
        }

        return min_depth + 1;
    }
}
