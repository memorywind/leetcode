package leetcode128;

import java.util.*;

public class main {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int num = nums[i];
            if (num + 1 == nums[i + 1]) {
                longest++;
            } else if (num == nums[i + 1]) {
                continue;
            } else {
                map.put(num, longest);
                longest = 1;
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            longest = Math.max(longest, entry.getValue());
        }
        return longest;
    }
}
