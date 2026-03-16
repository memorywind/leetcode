package leetcode101;

public class main {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isEqual(root.left, root.right);
    }

    public boolean isEqual(TreeNode leftRoot, TreeNode rightRoot) {
        if(leftRoot == null && rightRoot == null){
            return true;
        }
        if(leftRoot == null || rightRoot == null){
            return false;
        }
        if(leftRoot.val != rightRoot.val){
            return false;
        }
        return isEqual(leftRoot.left, rightRoot.right) && isEqual(leftRoot.right, rightRoot.left);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
