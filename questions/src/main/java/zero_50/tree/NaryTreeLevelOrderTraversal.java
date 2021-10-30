package zero_50.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LC429 这道题让我很惊艳，保存子节点使用List
 * N叉树的层序遍历
 */
public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrder(NNode root) {
        if (root==null){
            return result;
        }
        Deque<NNode> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            ArrayList<Integer> itemList = new ArrayList<>();
            int len = deque.size(); // 很精妙得使用了len保存deque的长度 在出队列的时候，一定要提前将队列的size保存为一个变量。
            while (len>0){
                NNode temp = deque.poll();
                itemList.add(temp.val);
                if (temp.children!=null){
                    for (NNode child : temp.children) {
                        deque.offer(child);
                    }
                }
                len--;
            }
            result.add(itemList);

        }
        return result;
    }
    // 同样dfs最终要的步骤是用deep标记了每一层。
    public void dfs(NNode root,Integer deep){
        if (root==null){
            return;
        }
        deep++;
        if (result.size()<deep){
            ArrayList<Integer> itemList = new ArrayList<>();
            result.add(itemList);
        }
        result.get(deep-1).add(root.val);
        for (NNode child : root.children) {
            dfs(child,deep);
        }
    }
}
