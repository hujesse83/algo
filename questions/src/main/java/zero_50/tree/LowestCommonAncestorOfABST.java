package zero_50.tree;

/**
 * 注意：这个是二叉搜索树了
 * @Time 2021/11/14 15：55
 * @Description 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 */
public class LowestCommonAncestorOfABST {
    // 自己写的
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null ||root==p||root==q){
            return root;
        }
        if (p.val<root.val && q.val>root.val || q.val<root.val && p.val>root.val){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        return left==null?right:left;
    }
    // 答案
    public TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorV2(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorV2(root.right, p, q);
        return root; // 左小右大
    }
}
