package leetcode22;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        String temp = "";
        dfs(n, 0, 0, temp, ans);
        return ans;
    }

    public void dfs(int n, int left, int right, String tmp, List<String> ans) {
        if (left == n && right == n) {
            ans.add(tmp);
            return;
        }
        if (left < n) {
            dfs(n, left + 1, right, tmp + '(', ans);
        }
        if (right < left) {

            dfs(n, left, right + 1, tmp + ')', ans);
        }
    }

    public static void main(String[] args) {
        String a = "123456789";
        System.out.println(a.substring(0, 3));
    }
}
