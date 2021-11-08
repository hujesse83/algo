package zero_50.tree;


import java.util.ArrayList;

import java.util.List;

/**
 * LC 112 路径总和、给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和、
 * LC 113 Path Sum II
 * @Time 2021/11/8 00:31
 * @考点：递归函数什么时候要有返回值，什么时候没有返回值，特别是有的时候递归函数返回类型为bool类型。
 * @考点：递归函数什么时候要有返回值，什么时候没有返回值，特别是有的时候递归函数返回类型为bool类型。
 * @考点：递归函数什么时候要有返回值，什么时候没有返回值，特别是有的时候递归函数返回类型为bool类型。
 * 重要的事情说三遍！！！我们通过下面二道题吃透
 * 感谢代码随想录https://programmercarl.com/0112.%E8%B7%AF%E5%BE%84%E6%80%BB%E5%92%8C.html#%E9%80%92%E5%BD%92 这篇文章
 */
public class PathSum {
    // 1、第一题 只是判断
    //如果要搜索其中一条符合条件的路径，那么递归一定需要返回值，因为遇到符合条件的路径了就要及时返回
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
    //2、第二题 找出所有
    //如果需要搜索整颗二叉树且不用处理递归返回值，递归函数就不要返回值
    public List<List<Integer>> res = new ArrayList<>();
    public int x = 0;
    public  List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<Integer> cur = new ArrayList<>();
        dfs(root,cur,targetSum);
        return res;
    }

    public  void dfs(TreeNode root, List<Integer> cur,int targetSum) {
        if (root==null){
            return;
        }
        if (root.left==null && root.right==null && targetSum-root.val==0){
            cur.add(root.val);
            List<Integer> item = new ArrayList<>(cur);  //创建一个新的
            res.add(item);
            cur.remove(cur.size()-1);
            return;
        }
        cur.add(root.val);
        dfs(root.left,cur,targetSum-root.val);
        dfs(root.right,cur,targetSum-root.val);
        cur.remove(cur.size()-1);  // 回朔的体现
    }
}
