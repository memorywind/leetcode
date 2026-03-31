package leetcode131;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(s,res,temp,0);
        return res;
    }

    public void dfs(String s, List<List<String>> res, List<String> temp, int index) {
        if (index == s.length()) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isHW(s,index,i)) {
                temp.add(s.substring(index, i + 1));
                dfs(s, res, temp, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public boolean isHW(String s,int left,int right) {
        while (left < right) {
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }
}
