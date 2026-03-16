package leetcode104;

public class main {
    public static void main(String[] args) {

    }

    public int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null){
            return 0;
        }
        depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        return depth;
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
