package leetcode46;

import java.util.ArrayList;
import java.util.List;

public class demo {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        dfs(ans, tmp, nums);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int j;
            for (j = 0; j < tmp.size(); j++) {
                if (nums[i] == tmp.get(j)) {
                    break;
                }
            }
            if (j == tmp.size()) {
                tmp.add(nums[i]);
                dfs(ans, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }

    }
}
