package zero_50.tree;


import java.util.Deque;
import java.util.LinkedList;
// LC116 .填充每个节点的下一个右侧节点指针

/**
 * 难点在于 使用常数空间
 */
public class PopulatingNextRightPointersInEachNode {
    public static Node connect(Node root) {
        if (root==null){
            return null;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int len = deque.size();
            while (len>0){
                  Node tmpNode = deque.pop();
                if (len>0) tmpNode.next = deque.peek();
                if (tmpNode.left!=null) deque.add(tmpNode.left);
                if (tmpNode.right!=null) deque.add(tmpNode.right);
                len--;
                if (len==0){
                    tmpNode.next = null;
                }
            }
        }
        return root;
    }
    //思路就是上层的next节点已经连接好了
    public Node connectV2(Node root){
        if (root==null){
            return null;
        }
        if (root.left!=null){
            root.left.next = root.right;
            if (root.next!=null){
                root.right.next = root.next.left;
            }
        }
        connectV2(root.left);
        connectV2(root.right);
        return root;
    }
}
