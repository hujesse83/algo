package zero_50.random.easy.Jan9;

import zero_50.random.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author jesse.hu
 * @date 2022/1/9 23:06
 * @LeetCodeNo 104
 * @Desc 求树的最大深度
 */
public class MaximumDepthOfBinaryTree {
    // 1、DFS
    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left,right)+1;
    }

    //2、BFS. 因为BFS是层序遍历
    public int maxDepthV2(TreeNode root) {
        if (root==null){
            return 0;
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size>0){
                TreeNode temp = deque.poll();
                if (temp.left!=null){
                    deque.offer(temp.left);
                }
                if (temp.right!=null){
                    deque.offer(temp.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }
}
