package zero_50.greedy;

import zero_50.tree.TreeNode;

/**
 * @Author huJesse
 * @Date 2021/11/29 09：19
 * 2021/12/1  sorry nothing to do today.
 * 思路 ：递归实现。摄像头不能放在叶子节点上。从低到上。
 * 难点：1、二叉树的遍历
 *      2、如何隔二个节点放一个摄像头  状态转移！！ 每个节点有三种状态
 * 所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
 */
public class BinaryTreeCameras {
    public int minCameraCover(TreeNode root) {
        if (root==null){
            return 0;
        }
        int left = minCameraCover(root.left);
        int right = minCameraCover(root.right);
        // 处理单层逻辑
        if (left==0 && right==0){
            return 0;
        }else {
            return left+right;
        }
        //此时需要状态转移的公式，大家不要和动态的状态转移公式混到一起，本题状态转移没有择优的过程，就是单纯的状态转移！
    }

}
