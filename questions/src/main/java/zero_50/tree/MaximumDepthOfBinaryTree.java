package zero_50.tree;

//LC111 有点难度
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        if (root.left!=null && root.right!=null){
            return Math.min(maxDepth(root.left),maxDepth(root.right))+1;
        }
        if (root.left==null && root.right!=null){
            return maxDepth(root.right)+1;
        }
        if (root.right==null && root.left!=null){
            return maxDepth(root.left)+1;
        }
        return 1;
    }


}
