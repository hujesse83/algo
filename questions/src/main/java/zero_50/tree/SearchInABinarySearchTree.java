package zero_50.tree;

/**
 * 这道题考察的是 "二叉搜索树即为二叉排序树"的技巧  简称BST
 * 唔 当时误以为是线索二叉树
 * 这里的性质是：左子树上所有节点的值均小于它的根节点的值
 *             右子树上所有节点的值均大于它根节点的值
 *
 * @Time 2021/11/12 15:40 面基了soul小姐姐
 * LC 700
 */
public class SearchInABinarySearchTree {
    // 这是使用了普通二叉树的做法
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null ){
            return null;
        }
        if(root.val==val){
            return root;
        }
        searchBST(root.left,val);
        searchBST(root.right,val);
        return null;
    }
    // 递归，利用二叉搜索树特点，优化
    public TreeNode searchBSTV2(TreeNode root, int val) {
        if (root == null || root.val==val) {
            return root;
        }
        if (val < root.val) {
            return searchBSTV2(root.left, val);
        } else {
            return searchBSTV2(root.right, val);
        }
    }
}
