package zero_50.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    // V1 用String拼接字符串很占空间
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<>();
        if (root==null){
            return ret;
        }
        solve(root,"",ret);
        return ret;
    }
    public void solve(TreeNode root,String cur,List<String> ret){
        if (root==null){
            return;
        }
        cur+=root.val;
        if (root.left==null && root.right==null){
            ret.add(cur);
        }else {
            solve(root.left,cur+"->",ret);
            solve(root.right,cur+"->",ret);
        }
    }
    // V2 使用StringBuilder
    public List<String> binaryTreePathsV2(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
