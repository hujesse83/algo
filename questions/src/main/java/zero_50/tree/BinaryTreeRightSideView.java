package zero_50.tree;

import java.util.*;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 *Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * 层序遍历的时候，判断是否遍历到单层的最后面的元素，如果是，就放进result数组中，随后返回result就可以了。
 */
// LC199 二叉树的右视图
public class BinaryTreeRightSideView {

    // 方法1 BinaryTreeLevelOrderTraversal.dfs 得到每层List , List反转取第一个 比较Low
    //方法二 利用队列bfs 精彩的是for循环
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> itemList = new ArrayList<>();
        if (root==null){
            return itemList;
        }
        Queue<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            for (int i = 0; i <len ; i++) {
                TreeNode temp = deque.poll();
                if (temp.left!=null) deque.offer(temp.left);
                if (temp.right!=null) deque.offer(temp.right);
                //将当前层的最后一个节点放入结果列表
                if (i==len-1){
                    itemList.add(temp.val);
                }
            }
        }
        return itemList;
    }
    public ArrayList<Integer> itemList = new ArrayList<>();
    // 方法三 采用递归的方式
    public void rightSideViewV2(TreeNode root, Integer deep){
        if (root==null){
            return ;
        }
        if (deep==itemList.size()){
            itemList.add(root.val);
        }
        deep++;
        rightSideViewV2(root.right,deep);
        rightSideViewV2(root.left,deep);
    }
}
