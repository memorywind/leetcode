package leetcode230;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public int kthSmallest(TreeNode root, int k) {
        // 使用中序遍历得到递增的序列
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans.get(k - 1);
    }

    public class TreeNode {
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

    public void inorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}
