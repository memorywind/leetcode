package leetCode94;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {

    }

    /*
    * f(1)
    * f(2)=f(1.left)
    * 4=f(2.left)
    *
    *
    *
    *
    *
    *
    * */

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        method(res,root);
        return res;

    }
    public static void method(List<Integer> list , TreeNode root){
        if(root == null){
            return;
        }
        method(list,root.left);
        list.add(root.val);
        method(list,root.right);
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
