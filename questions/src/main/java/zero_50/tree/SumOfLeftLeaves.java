package zero_50.tree;

/**
 * @Time 2021/11/7 15：55
 * 左叶子的明确定义：如果左节点不为空，且左节点没有左右孩子，那么这个节点就是左叶子
 * LC404
 */
public class SumOfLeftLeaves {
    // 自己野方法 ... 设置了左节点flag为1，右节点flag为2；
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null){
            return 0;
        }
        return dfs(root.left,1)+dfs(root.right,0);

    }
    public  int dfs(TreeNode root,int flag){
        if (root==null){
            return 0;
        }
        if (root.left==null && root.right==null && flag==1){
            return root.val;
        }
        return dfs(root.left,1) + dfs(root.right,0);
    }
    // 官方解法！！
    public int sumOfLeftLeavesV2(TreeNode root) {
        if (root==null){
            return 0;
        }
        int res = 0;
        if (root.left!=null && root.left.left==null &&root.left.right==null){
            res +=root.left.val;
        }
        return sumOfLeftLeaves(root.left)+sumOfLeftLeaves(root.right)+res;
    }
}
