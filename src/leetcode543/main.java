package leetcode543;

public class main {
    public static void main(String[] args) {

    }

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        getMax(root);
        return ans -1 ;
    }

    public int getMax(TreeNode root) {
        int depth = 0;
        if (root == null) {
            return 0;
        }
        int L = getMax(root.left); // 左儿子为根的子树的深度
        int R = getMax(root.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        depth = Math.max(getMax(root.left), getMax(root.right)) + 1;
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

