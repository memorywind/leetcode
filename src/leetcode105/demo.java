package leetcode105;

import java.util.Arrays;

public class demo {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        int headVal = preorder[0];
        int index=0;
        TreeNode head = new TreeNode(headVal);
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == headVal) {
                index = i;
                break;
            }
        }
        int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        head.left = buildTree(leftPre, leftIn);
        int[] rightPre = Arrays.copyOfRange(preorder, index + 1, preorder.length);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);
        head.right = buildTree(rightPre, rightIn);
        return head;
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
}
