package zero_50.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//LC107  在102的基础上 将List反转一下即可。

/**
 * input [3,9,20,null,null,15,7]
 * output  [[15,7],[9,20],[3]]
 */
public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        BinaryTreeLevelOrderTraversal.dfs(root,0);
         Collections.reverse(result);
         return result;
    }

}
