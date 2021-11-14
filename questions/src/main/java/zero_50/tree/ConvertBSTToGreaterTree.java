package zero_50.tree;

/**
 * @Description 请你将其转换为累加树（Greater Sum Tree）
 * LC 538
 * @Time 2021/11/14 22：57
 * 这是我跟着代码随想录二叉树系列最后一道题了 呼 下一步开始回朔算法
 */
public class ConvertBSTToGreaterTree {
    // 反中序遍历地累加
    public int temp = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root==null){
            return null;
        }
        convertBST(root.right);
        root.val = temp+ root.val;
        temp = root.val;;
        convertBST(root.left);
        return root;
    }
}
