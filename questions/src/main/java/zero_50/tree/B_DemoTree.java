package zero_50.tree;

import java.util.Stack;

public class B_DemoTree {
    private int val;
    private B_DemoTree left;
    private B_DemoTree right;

    B_DemoTree() {
    }

    B_DemoTree(int val) {
        this.val = val;
    }

    B_DemoTree(int val, B_DemoTree left, B_DemoTree right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    //Binary Tree Preorder Traversal LC144
    void preOrder(B_DemoTree node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
    // 非递归
    void preOrderV2(B_DemoTree node){
        if (node==null){
            return;
        }
        Stack<B_DemoTree> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            B_DemoTree temp = stack.pop();
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
    void infixOrder(B_DemoTree node) {
        if (node == null) {
            return;
        }
        infixOrder(node.left);
        System.out.println(node.val);
        infixOrder(node.right);
    }
    //非递归
    void infixOrderV2(B_DemoTree node){
        B_DemoTree temp = node;
        Stack<B_DemoTree> stack = new Stack<>();
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
    void postOrder(B_DemoTree node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }
    // 非递归
    public static void postOrderV2(B_DemoTree root) {
        Stack<B_DemoTree> stack1 = new Stack<>();
        Stack<B_DemoTree> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            B_DemoTree temp = stack1.pop();
            stack2.push(temp);
            if(temp.left!=null){
                stack1.push(temp.left);
            }
            if(temp.right!=null){
                stack1.push(temp.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }

}
