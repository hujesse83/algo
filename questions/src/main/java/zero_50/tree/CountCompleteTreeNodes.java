package zero_50.tree;

/**
 * 计算一颗完全二叉树..
 * 完全二叉树的性质：完全二叉树只有两种情况，情况一：就是满二叉树，情况二：最后一层叶子节点没有满。
 */
public class CountCompleteTreeNodes {

    // 彩笔的我只能写出普通二叉树的求法..根本想不到完全二叉树的特性
    public int countNodes(TreeNode root) {
        if (root==null){
            return 0;
        }
        int leftNum = countNodes(root.left);  //左
        int rightNum = countNodes(root.right);  //右
        int treeNum = leftNum + rightNum + 1;      // 中
        return treeNum;
    }
    // 精简版普通二叉树求法
    public int countNodesV2(TreeNode root){
        return root==null?0:1+countNodesV2(root.left)+countNodesV2(root.right);
    }
    // 利用完全二叉树性质
    public int countNodesV3(TreeNode node){
        //  在子树中找完全二叉树
        return 0;
    }

}
