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




    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode s4 = new TreeNode(4);
        TreeNode s8 = new TreeNode(8);
        TreeNode s11 = new TreeNode(11);
        TreeNode s7 = new TreeNode(7);
        TreeNode s2 = new TreeNode(2);
        TreeNode s13 = new TreeNode(13);
        TreeNode ss4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);
        TreeNode s1 = new TreeNode(1);
        root.left = s4;
        root.right = s8;
        s4.left = s11;
        s8.left = s13;
        s8.right = ss4;
        s11.left = s7;
        s11.right = s2;
        ss4.left = s5;
        ss4.right = s1;
    }

}
