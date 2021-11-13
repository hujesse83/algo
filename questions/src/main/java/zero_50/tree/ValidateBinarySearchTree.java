package zero_50.tree;


import java.util.ArrayList;
import java.util.List;

/**
 * LC 98
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * @Time 2021/14 01:50
 * 
 */
public class ValidateBinarySearchTree {
    // 方法一：使用了BST中序遍历为生序 使用额外空间存储
    public List<Integer> res = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        dfs(root);
        for(int i =0;i<res.size()-1;i++) {
            if (res.get(i) > res.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        res.add(root.val);
        dfs(root.right);
    }
    // 方法二：使用递归,使用一个变量保存中序遍历pre值
    /*
    中序遍历值就是个升序数组，每次判断的时候用上一个值跟当前root.val比较，这样就是保障了升序，省了单独的数组校验升序业务。
     */
    double last = -Double.MAX_VALUE;
    public boolean isValidBSTV2(TreeNode root){
        if (root==null){
            return true;
        }
        if (isValidBSTV2(root.left)){
            if (last<root.val){
                last = root.val;
                return isValidBSTV2(root.right);
            }
        }
        return false;
    }

}
