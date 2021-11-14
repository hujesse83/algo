package zero_50.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description ： 找BST出现频率最高的值
 * 很巧妙地使用了全局变量 很NB
 * LC501
 * @Time 2021/11/14 14：30
 */
public class FindModeInBinarySearchTree {
    public int preVal = 0;
    public int curTimes = 0;
    public int maxTimes = 0;
    public List<Integer> res = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        dfs(root);
        int[] ans = new int[res.size()];
        for (int i = 0; i <res.size() ; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
    // BST 中序遍历是递增
    public void dfs(TreeNode root){
        if (root==null){
            return;
        }
        dfs(root.left);
        if(preVal==root.val){
            curTimes++;
        }else {
            preVal = root.val;
            curTimes = 1;
        }
        if (curTimes==maxTimes){
            res.add(root.val);
        }else if(curTimes>maxTimes){
            res.clear();
            res.add(root.val);
            maxTimes = curTimes;
        }
        dfs(root.right);
    }
}
