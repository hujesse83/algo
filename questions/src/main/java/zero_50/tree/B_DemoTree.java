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
    //Binary Tree Preorder Traversal LC145
    void postOrder(B_DemoTree node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val);
    }

}
