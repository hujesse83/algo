package zero_50.tree;

import java.util.Deque;
import java.util.LinkedList;

//LC111 有点难度 求树的深度
//LC559  求树的深度 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        if (root.left!=null && root.right!=null){
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
        if (root.left==null && root.right!=null){
            return maxDepth(root.right)+1;
        }
        if (root.right==null && root.left!=null){
            return maxDepth(root.left)+1;
        }
        return 1;
    }
    // 做递归题目只看本
    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthV2(root.left);
        int rightDepth = maxDepthV2(root.right);
        return Math.max(leftDepth, rightDepth) + 1;

    }
    // 也可以使用层序遍历
    public Integer n = 0;
    public void  maxDepthV3(TreeNode root,Integer deep) {
        if (root==null){
            return ;
        }
        deep++;
        n = deep>n?deep:n;
        maxDepthV3(root.left,deep);
        maxDepthV3(root.right,deep);
    }
    // 这时 层数就是n LC599
    public void  maxDepthV4(NNode root,Integer deep) {
        if (root==null){
            return ;
        }
        deep++;
        deep = deep>n?deep:n;
        for (NNode node:root.children){
            maxDepthV4(node,deep);
        }
    }
    // 树的最大深度迭代法 使用队列
    public int   maxDepthV5(TreeNode root) {
        if (root==null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size>0){
                TreeNode temp = deque.poll();
                if (temp.left!=null)
                deque.offer(temp.left);
                if (temp.right!=null)
                deque.offer(temp.right);
                size--;
            }
            depth++;
        }
        return depth;
    }


}
