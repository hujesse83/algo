package zero_50.tree;

/**
 * @Description 找到该树中两个指定节点的最近公共祖先
 * @图解：https://programmercarl.com/0236.%E4%BA%8C%E5%8F%89%E6%A0%91%E7%9A%84%E6%9C%80%E8%BF%91%E5%85%AC%E5%85%B1%E7%A5%96%E5%85%88.html#java
 * @Time：2021/11/14 15：45
 * 自我理解：后续遍历+回朔    用left 和 right 接收到了返回的值
 */
public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left != null && right != null) {// 左右子树分别找到了，说明此时的root就是要求的结果
            return root;
        }
        if (left == null) {
            return right;
        }
        return left;
    }
}
