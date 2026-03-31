package leetcode78;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(nums,ans,tmp,0);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> tmp , int pathLen) {
        if(pathLen == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        tmp.add(nums[pathLen]);
        dfs(nums, ans, tmp, pathLen+1);
        tmp.remove(tmp.size()-1);
        dfs(nums, ans, tmp, pathLen+1);
    }
}
