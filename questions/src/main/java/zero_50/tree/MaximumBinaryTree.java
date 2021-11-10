package zero_50.tree;

/**
 * @Time：2021/11/10 15：54
 *
 */
public class MaximumBinaryTree {
    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums,0, nums.length-1);
    }
    public static TreeNode  dfs(int []nums,int left,int right){
        if (left>right){
            return null;
        }
        int temp = nums[left];
        int index = left;  // 这一步是重点哇  有了`通过前中`构造二叉树的经验
        for (int i = left; i <=right ; i++) {
            if (nums[i]>temp){
                temp = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(temp);
        root.left = dfs(nums,left,index-1);
        root.right = dfs(nums,index+1,right);
        return root;
    }

}
