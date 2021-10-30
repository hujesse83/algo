package zero_50.tree;

import java.util.*;
// LC 637 求每一层节点的平均值
public class AverageOfLevelsInBinaryTree {
    public static List<Double> res = new LinkedList<>();
    public static List<Double> averageOfLevels(TreeNode root) {
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
            System.out.println('k');
            res.add(itemList.stream().mapToDouble(x->x).average().getAsDouble());
        }
        return res;
    }

    // 真无语LC的编译器 ...
    public static void main(String[] args) {
        TreeNode s1 = new TreeNode(3);
        TreeNode s2 = new TreeNode(9);
        TreeNode s3 = new TreeNode(20);
        TreeNode s4 = new TreeNode(15);
        TreeNode s5 = new TreeNode(7);
        s1.left = s2;
        s1.right = s3;
        s3.left = s4;
        s3.right = s5;
        averageOfLevels(s1);
        System.out.println(res);
    }
}
