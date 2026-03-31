package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class demo {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0 || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i + 1, R = nums.length - 1;
            while (L < R) {
                if (nums[i] + nums[L] + nums[R] > 0) {
                    R--;
                } else if (nums[i] + nums[L] + nums[R] < 0) {
                    L++;
                }else{
                    ArrayList<Integer> sub = new ArrayList<>();
                    Collections.addAll(sub, nums[i], nums[L], nums[R]);
                    ans.add(sub);
                    // 跳过重复的L和R
                    while (L < R && nums[L] == nums[L+1]) L++;
                    while (L < R && nums[R] == nums[R-1]) R--;
                    L++;
                    R--;
                }
            }
        }
        return ans;
    }
}
