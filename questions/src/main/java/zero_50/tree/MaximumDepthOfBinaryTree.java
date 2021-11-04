package zero_50.tree;

//LC111 有点难度 求树的高度
//LC559  求树的深度 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null){
            return 1;
        }
        if (root.left!=null && root.right!=null){
            return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
        }
        if (root.left==null && root.right!=null){
            return maxDepth(root.right)+1;
        }
        if (root.right==null && root.left!=null){
            return maxDepth(root.left)+1;
        }
        return 1;
    }
    // 做递归题目只看本层
    public int maxDepthV2(TreeNode root) {
        return root==null?0:Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    // 也可以使用层序遍历
    public Integer n = 0;
    public void  maxDepthV3(TreeNode root,Integer deep) {
        if (root==null){
            return ;
        }
        deep++;
        deep = deep>n?deep:n;
        maxDepthV3(root.left,deep);
        maxDepthV3(root.right,deep);
    }
    // 这时 层数就是n

}
