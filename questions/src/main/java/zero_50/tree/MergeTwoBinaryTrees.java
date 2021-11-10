package zero_50.tree;

/**
 * 合并二叉树
 * LC617
 * @Time 2021/11/11 01：49
 */
public class MergeTwoBinaryTrees {
    // 不是new 新的TreeNode，而是保留树A，避免了null.left 造成NullPointerException的问题
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1==null){
            return root2;
        }
        if (root2==null){
            return root1;
        }
        root1.val = root1.val+root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root2.right = mergeTrees(root1.right,root2.right);
        return root1;
    }
}
