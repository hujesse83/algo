package zero_50.tree;

import java.util.*;

// 层序遍历
//LC102 层序遍历并输出
/**
    // input [3,9,20,null,null,15,7]
    // output  [[3],[9,20],[15,7]]
 */
public class bfs_traverse {
    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(1);
        TreeNode s2 = new TreeNode(2);
        TreeNode s3 = new TreeNode(3);
        TreeNode s4 = new TreeNode(4);
        TreeNode s5 = new TreeNode(5);
        s1.left = s2;
        s1.right = s3;
        s2.left = s4;
        s3.right = s5;
        checkFun01(s1,0);
        System.out.println(result);
    }
    public static List<List<Integer>> result = new LinkedList<>();

    // LC102 这里使用了BFS队列，唯一卡在了如何标记每一层。

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if (root ==null){
            return res;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            List<Integer> itemList = new ArrayList<>();
            int len = deque.size();
            while (len>0){
                TreeNode tmpNode = deque.pop();
                itemList.add(tmpNode.val);
                if (tmpNode.left!=null) deque.add(tmpNode.left);
                if (tmpNode.right!=null) deque.add(tmpNode.right);
                len--;
            }
            res.add(itemList);
        }
        return res;
    }
    // 张见识了 这段代码  层级遍历还可以dfs
    // 搁置10/30
    public static void checkFun01(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (result.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<>();
            result.add(item);
        }
        result.get(deep - 1).add(node.val);

        checkFun01(node.left, deep);
        checkFun01(node.right, deep);
    }

}
