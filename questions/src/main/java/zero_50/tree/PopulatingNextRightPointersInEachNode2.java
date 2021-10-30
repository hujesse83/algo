package zero_50.tree;

// LC 117 这道题目说是二叉树，但116题目说是完整二叉树
public class PopulatingNextRightPointersInEachNode2 {
    public static Node connect(Node root) {
        PopulatingNextRightPointersInEachNode.connect(root);
        return root;
    }
}
