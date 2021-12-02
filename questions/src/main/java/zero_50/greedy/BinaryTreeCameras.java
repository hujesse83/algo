package zero_50.greedy;

import zero_50.tree.TreeNode;

/**
 * @Author huJesse
 * @Date 2021/11/29 09：19
 * 2021/12/1  sorry nothing to do today.
 * 2021/12/2 get it done
 * 思路 ：递归实现。摄像头不能放在叶子节点上。从低到上。
 * 难点：1、二叉树的遍历
 * 2、如何隔二个节点放一个摄像头  状态转移！！ 每个节点有三种状态
 *      0：该节点无覆盖
 *      1：本节点有覆盖
 *      2：本节点有摄像头
 * 所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
 */
public class BinaryTreeCameras {
    private int count = 0;

    public int minCameraCover(TreeNode root) {
        if (trval(root) == 0) count++; // root节点可能没覆盖
        return count;
    }

    private int trval(TreeNode root) {
        if (root == null) return -1;
        int left = trval(root.left);
        int right = trval(root.right);
        if (left == 0 || right == 0) {  // 叶子节点
            count++;
            return 2;
        }
        if (left == 2 || right == 2) {
            return 1;
        }
        return 0;
    }

}
