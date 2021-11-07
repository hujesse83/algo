package zero_50.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目分析：在树的最后一行找到最左边的值。
 * @Time：2021/11/7 16：31
 * LC 513
 * 思路：层序遍历是非常简单的了，反而用递归的话会比较难一点。
 */
public class FindBottomLefTreeValue {
    // 方法一：层序遍历放在二维List中，取出最后一层第一个即可。
    List<List<TreeNode>> res = new ArrayList<>();
    public int findBottomLeftValue(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfs(root,0);
        int len = res.size();
        return res.get(len-1).get(0).val;
    }
    public void dfs(TreeNode root,int deep){
        if (root==null){
            return;
        }
        deep++;
        if (deep > res.size()){
            ArrayList<TreeNode> item = new ArrayList<>();
            res.add(item);
        }
        res.get(deep-1).add(root);
        dfs(root.left,deep);
        dfs(root.right,deep);
    }
    // 方法二： dfs
    public int findBottomLeftValueV2(TreeNode root) {
        if (root==null){
            return 0;
        }
        dfsV2(root,0);
        return result;

    }
    public int maxDeep = 0;  // 记录最大深度
    public int result = 0;   // 记录最大深度最左节点的值
    public void dfsV2(TreeNode root,int deep){
        if (root==null){
            return;
        }
        deep++;
        if (root.left==null && root.right==null){
            if (maxDeep<deep){
                maxDeep = deep;
                result = root.val;
            }
        }
        dfsV2(root.left,deep);
        dfsV2(root.right,deep);
    }
    // 解法三 BFS
    public int findBottomLeftValueV3(TreeNode root){
        if (root==null){
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        TreeNode temp = root;
        while (!deque.isEmpty()){
             temp= deque.poll();
            if (temp.right!=null){
                deque.offer(temp.right);
            }
            if (temp.left!=null){
                deque.offer(temp.left);
            }
        }
        return temp.val;
    }
}
