package leetcode1;

import java.util.HashMap;
import java.util.Map;

public class demo {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
            }else{
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}
