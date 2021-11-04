package zero_50.tree;

import java.util.*;

// 对称二叉树 LC101
/*
不要只是AC，要去接受多样思路，多思考;不要被`灌输的知识`或者`记住的知识`所局限住了.
今天是我放下手机的第一天，也是我打开思想的第一天;
2021/11/2
 */
public class SymmetricTree {
    // 提交13次的菜鸡写的，大体思路是层序遍历放入二维数组，看itemList是否对称，空节点填充-1000
    public boolean isSymmetric(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            List<Integer> itemList = new ArrayList<>();
            int len = deque.size();
            while (len > 0) {
                TreeNode tmpNode = deque.pop();
                itemList.add(tmpNode.val);
                if (tmpNode.val != -1000) {
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
            int j = itemList.size() - 1;
            while (i < j) {
                if (itemList.get(i) != itemList.get(2)) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }
    //两个子树的里侧和外侧的元素是否相等
    public boolean isSymmetricV2(TreeNode left,TreeNode right) {
        //判定左右节点和自身
        if (left==null && right==null){
            return true;
        }
        if (left==null || right==null ||left.val!= right.val){
            return false;
        }
        //此时才进入单层递归的逻辑，单层递归的逻辑就是处理 左右节点都不为空，且数值相同的情况。
        boolean outSide = isSymmetricV2(left.left,right.right);
        boolean inSide = isSymmetricV2(left.right,right.left);
        return outSide&&inSide;
    }
    // 这才是标准的迭代法...! 队列可以装null的 普通队列
    public boolean isSymmetricV3(TreeNode root) {
        if (root==null){
            return false;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root.left);
        deque.offer(root.right);
        while (!deque.isEmpty()){
            TreeNode nodeLeft = deque.poll();
            TreeNode nodeRight = deque.poll();
            if(nodeLeft==null&&nodeRight==null){
                continue;
            }
            if (nodeLeft==null || nodeRight==null ||nodeLeft.val!= nodeRight.val){
                return false;
            }
            // 成对成对地装入
            deque.offer(nodeLeft.right);
            deque.offer(nodeRight.left);
            deque.offer(nodeLeft.left);
            deque.offer(nodeRight.right);
        }
        return true;
    }
    // 使用双端队列 也行
    public boolean isSymmetricV4(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()){
            TreeNode nodeLeft = deque.pollFirst();
            TreeNode nodeRight = deque.pollLast();
            if(nodeLeft==null&&nodeRight==null){
                continue;
            }
            if (nodeLeft==null || nodeRight==null ||nodeLeft.val!= nodeRight.val){
                return false;
            }
            deque.offerFirst(nodeLeft.left);
            deque.offerFirst(nodeLeft.right);
            deque.offerLast(nodeRight.right);
            deque.offerLast(nodeRight.left);
        }
        return true;
        }
}



