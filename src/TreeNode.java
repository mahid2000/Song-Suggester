public class TreeNode {
    String v;
    TreeNode left;
    TreeNode right;

    public TreeNode(String v) {
        this.v = v;
        this.left = null;
        this.right = null;
    }

    public TreeNode(String v, TreeNode left, TreeNode right) {
        this.v = v;
        this.left = left;
        this.right = right;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public boolean isLeaf() {
        if (right == null && left == null) { 
            return true;
        } 
        else {
            return false;
        }
    }
}

 