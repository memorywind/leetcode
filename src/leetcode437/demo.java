package leetcode437;

import java.util.LinkedList;
import java.util.Queue;

public class demo {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int total=0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            total = total+dfs(poll, 0, targetSum);
            if(poll!=null) {
                queue.add(poll.left);
                queue.add(poll.right);
            }
        }
        return total;
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

    int dfs(TreeNode root, long curSum, int target) {
        if (root == null) {
            return 0;
        }
        curSum += root.val;
        int count = 0;
        if (curSum == target) {
            count = count + 1;
        }
        count = count + dfs(root.left, curSum, target);
        count = count + dfs(root.right, curSum, target);
        return count;
    }
}
