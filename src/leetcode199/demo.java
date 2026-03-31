package leetcode199;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class demo {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            TreeNode right = null;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(cur!=null) {
                    right=cur;
                    queue.add(cur.left);
                    queue.add(cur.right);
                }
            }
            if(right!=null) {
                ans.add(right.val);
            }
        }
        return ans;
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


    public List<Integer> levelOrder(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                ans.add(head.val); // 每次取出队列的头部添加进结果，然后将头部节点的子节点都加入队列
                if (head.left != null) queue.add(head.left);
                if (head.right != null) {
                    queue.add(head.right);
                    ans.add(head.right.val);
                };
            }

        }
        return ans;
    }
}
