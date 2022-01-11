package zero_50.random.easy.Jan9;

import zero_50.random.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jesse.hu
 * @date 2022/1/9 22:38
 * @LeetCodeNo  94
 * 首先我们需要了解什么是二叉树的中序遍历：按照访问左子树——根节点——右子树的方式遍历这棵树，
 * 而在访问左子树或者右子树的时候我们按照同样的方式遍历，直到遍历完整棵树。
 * 因此整个遍历过程天然具有递归的性质，我们可以直接用递归函数来模拟这一过程
 */
public class BinaryTreeInorderTraversal {
    private final List<Integer> res = new ArrayList<>(); // final修饰
    public List<Integer> inorderTraversal(TreeNode root) {
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if (node==null){
            return ;
        }
        dfs(node.left);
        res.add(node.val);   // 树的先序、中序、后序 只需要调换 '根'这一行
        dfs(node.right);
    }
}
