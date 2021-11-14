package zero_50.tree;

/**
 * @Time 2021/11/14 17:13
 * LC 450
 * BST的删除 分为二种情况
 *          一：删除叶子节点
 *          二：删除非叶子节点，需要左旋或者右旋
 * @Description: 搜索树的节点删除要比节点增加复杂的多，有很多情况需要考虑，做好心里准备。
 * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
 * 找到删除的节点
 * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
 * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
 * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
 * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。

 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root==null){
            return null;
        }
        if(root.val==key){
            if (root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else {
                // 左右都存在
                TreeNode cur = root.right;
                while (cur.left!=null){
                    cur = cur.left;
                }
                cur.left = root.left;
                root = root.right;
                return root;
            }
        }
        if (key> root.val){  // 向右
            root.right = deleteNode(root.right,key);
        }else {
            root.left = deleteNode(root.left,key);
        }
        return root;
    }
}
