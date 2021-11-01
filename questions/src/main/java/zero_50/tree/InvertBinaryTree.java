package zero_50.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 226 反转二叉树
 * 听说 Homebrew的作者Max Howell，就是因为没在白板上写出翻转二叉树，最后被Google拒绝了
 */
// 使用前序遍历
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public  List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(NNode root) {
        if (root==null){
            return result;
        }
        result.add(root.val);
        for (NNode child : root.children) {
            preorder(child);
        }
        return result;
    }
}
