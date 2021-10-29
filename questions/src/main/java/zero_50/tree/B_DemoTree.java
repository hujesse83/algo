package zero_50.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class B_DemoTree {


    //Binary Tree Preorder Traversal LC144
    void preOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode.val);
        preOrder(treeNode.left);
        preOrder(treeNode.right);
    }
    // 非递归
    void preOrderV2(TreeNode treeNode){
        if (treeNode ==null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.println(temp.val);
            if (temp.right!=null){
                stack.push(temp.right);
            }
            if (temp.left!=null){
                stack.push(temp.left);
            }
        }
    }
    //Binary Tree Preorder Traversal LC94
    void infixOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        infixOrder(treeNode.left);
        System.out.println(treeNode.val);
        infixOrder(treeNode.right);
    }
    //非递归
    void infixOrderV2(TreeNode treeNode){
        TreeNode temp = treeNode;
        Stack<TreeNode> stack = new Stack<>();
        while (temp!=null || !stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            if (!stack.isEmpty()){
                System.out.println(stack.pop().val);
                temp = temp.right;
            }
        }
    }
    //Binary Tree Preorder Traversal LC145
    void postOrder(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        postOrder(treeNode.left);
        postOrder(treeNode.right);
        System.out.println(treeNode.val);
    }
    // 非递归
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
