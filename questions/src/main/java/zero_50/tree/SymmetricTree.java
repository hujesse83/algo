package zero_50.tree;

import java.util.*;

// 对称二叉树 LC101
public class SymmetricTree {
    // 提交13次的菜鸡写的，大体思路是层序遍历放入二维数组，看itemList是否对称，空节点填充-1000
    public boolean isSymmetric(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root ==null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = deque.size();
            while (len>0){
                TreeNode tmpNode = deque.pop();
                itemList.add(tmpNode.val);
                if (tmpNode.val!=-1000) {
                    if (tmpNode.left != null) deque.add(tmpNode.left);
                    else deque.add(new TreeNode(-1000));
                    if (tmpNode.right != null) deque.add(tmpNode.right);
                    else deque.add(new TreeNode(-1000));
                }
                len--;
            }
            res.add(itemList);
        }
        System.out.println(res);
        for (List<Integer> itemList : res) {
            int i = 0;
            int j = itemList.size()-1;
            while (i<j){
                if (itemList.get(i)!=itemList.get(2)){
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
    }



