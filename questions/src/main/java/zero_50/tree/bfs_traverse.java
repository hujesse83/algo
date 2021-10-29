package zero_50.tree;

import java.util.*;

// 层序遍历
//LC102 层序遍历并输出
public class bfs_traverse {
    public static void main(String[] args) {

    }

    // LC102 这里使用了BFS队列，唯一卡在了如何标记每一层。
    // input [3,9,20,null,null,15,7]
    // output  [[3],[9,20],[15,7]]
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
}
