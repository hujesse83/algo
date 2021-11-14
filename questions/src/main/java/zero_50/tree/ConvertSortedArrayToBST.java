package zero_50.tree;

/**
 * @Description 把排序数组转为BST + 平衡
 * LC 108
 * 很神奇 从中间取就是BST + 平衡的
 * @Time 2021/11/14 22：47
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums,0, nums.length-1);
    }
    public TreeNode dfs(int []nums,int left,int right){
        if (left>right){
            return null;
        }
        int mid = left +((right-left)>>1);  // 取中间 [left,right] 左闭右闭
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,left,mid-1);
        root.right = dfs(nums,mid+1,right);
        return root;
    }
}
