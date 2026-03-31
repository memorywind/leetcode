package leetcode114;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).left = null;
            list.get(i).right = list.get(i + 1);
        }
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

    public void inorder(TreeNode root, List<TreeNode> ans) {
        if (root == null) return;
        ans.add(root);
        if (root.left != null) inorder(root.left, ans);
        if (root.right != null) inorder(root.right, ans);
    }
}
