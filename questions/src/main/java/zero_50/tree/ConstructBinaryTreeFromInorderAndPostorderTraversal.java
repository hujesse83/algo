package zero_50.tree;


/**
 * @Time 2021/11/9 22:32
 * LC105 + LC 106
 * 前序和后序不能唯一确定一颗二叉树！，因为没有中序遍历无法确定左右部分
 * 这道题卡在了：如何确定下标.....
 * 这道题有点"分治"的思想了哈～
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    //
    public static TreeNode buildTreeV1(int[] inorder, int[] postorder) {
        return dfsV1(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static TreeNode dfsV1(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int val = postorder[postRight];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = dfsV1(postorder, postLeft, postLeft + (index - inLeft) - 1, inorder, inLeft, index - 1);
        root.right = dfsV1(postorder, postLeft + (index - inLeft), postRight - 1, inorder, index + 1, inRight);
        return root;
    }

    // 前序遍历+中序遍历构造二叉树
    public TreeNode buildTreeV2(int[] preorder, int[] inorder) {
        return dfsV2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode dfsV2(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                index = i;
                break;
            }
        }
        root.left = dfsV2(preorder, preLeft + 1, preLeft + (index - inLeft), inorder, inLeft, index - 1);
        root.right = dfsV2(preorder, preLeft + (index - inLeft) + 1, preRight, inorder, index + 1, inRight);
        return root;
    }

    // 可以debug一下检查树组下标状况
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode s9 = new TreeNode(9);
        TreeNode s20 = new TreeNode(20);
        TreeNode s15 = new TreeNode(15);
        TreeNode s7 = new TreeNode(7);
        root.left = s9;
        root.right = s20;
        s20.left = s15;
        s20.right = s7;
        int inorder[] = {9, 3, 15, 20, 7};
        int postorder[] = {9, 15, 7, 20, 3};
        buildTreeV1(inorder, postorder);
    }

}
