package zero_50.tree;

/**
 * @Description 二叉树的插入
 * @Time 2021/11/14 16：28
 * LC 701
 */
public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root==null){
            return new TreeNode(val);
        }
        if (root.val<val){ // 向右
            root.right = insertIntoBST(root.right,val);
        }else {
            root.left =  insertIntoBST(root.left,val);
        }
        return root;
    }
}
