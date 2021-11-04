package zero_50.tree;

/**
 * LC 572 子树问题
 * LC 100 相同的树
 * 对称可真美啊！
 * 一个树是另一个树的子树 则
 * 要么这两个树相等
 * 要么这个树是左树的子树
 * 要么这个树hi右树的子树
 */
public class IsSubTree {
    public boolean isSame(TreeNode root,TreeNode sub) {
        if(root==null&&sub==null)return true;
        return root!=null && sub!=null &&root.val==sub.val&& isSame(root.left,sub.left) && isSame(root.right,sub.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null&&subRoot==null)return true;
        if(root==null||subRoot==null)return false;
        return isSame(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
}
