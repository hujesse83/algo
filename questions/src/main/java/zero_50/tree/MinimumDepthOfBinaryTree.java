package zero_50.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2021/11/4 22:58
 * 最小深度：
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。，注意是叶子节点。
 * 什么是叶子节点，左右孩子都为空的节点才是叶子节点!!!
 */
public class MinimumDepthOfBinaryTree {
    // 假设根节点左节点为空，那么我们用树的最大深度套路的话就失策了.
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // null节点不参与比较
        if (root.left == null && root.right != null) {
            return 1 + minDepth(root.right);
        }
        // null节点不参与比较
        if (root.right == null && root.left != null) {
            return 1 + minDepth(root.left);
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
    // 迭代方式  还是记录下每一层，只要发现左节点与右节点为null  说明遇到了最短的
    public int minDepthV2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int deep = 0;
        while (!deque.isEmpty()){
            int len = deque.size();
            deep++;
            while (len>0){
                TreeNode temp = deque.poll();
                if (temp.left!=null){
                    deque.offer(temp.left);
                }
                if (temp.right!=null){
                    deque.offer(temp.right);
                }
                //是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                if (temp.left==null && temp.right==null){
                    return deep;
                }

                len--;
            }
        }
        return 1;
    }
}
