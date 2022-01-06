package zero_50.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: jesse.hu
 * @Date: 2022/1/5
 * @LC54 二叉搜索数的第K大节点
 */
public class KthBiggestValueInBST {
    /**
     *
     */
    private int count = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root==null){
            return -1;
        }
        kthLargest(root.right,k);
        count++;
        if (count==k) return root.val;
        kthLargest(root.left,k);
        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            Integer value = entry.getValue();
        }
        return 0;
    }

}
