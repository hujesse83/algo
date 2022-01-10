package zero_50.random.easy.Jan10;

import zero_50.random.TreeNode;

/**
 * @author jesse.hu
 * @date 2022/1/10 09:51
 * @LeetCodeNo 108
 * @Desc 将有序数组 转换为高度平衡的二叉排序树
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return divideAndConquer(nums,0,nums.length-1);
    }

    public TreeNode divideAndConquer(int []nums,int left,int right){
        if (left>right){
            return null;
        }
        int mid = left +((right-left)>>1);  // 取中间 [left,right] 左闭右闭
        TreeNode midNode = new TreeNode(nums[mid]);
        midNode.left = divideAndConquer(nums,left,mid-1);
        midNode.right = divideAndConquer(nums,mid+1,right);
        return midNode;
    }
}
