package zero_50.tree;

import java.util.List;

public class NNode {
    int val;
    List<NNode> children;

    public NNode(int val) {
        this.val = val;
    }

    public NNode(int val, List<NNode> children) {
        this.val = val;
        this.children = children;
    }
}
