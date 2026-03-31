package leetcode128;

import java.util.HashSet;
import java.util.Set;

public class demo {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for (int num : nums) {
            set.add(num);
        }
        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }
            int size = 1;
            while (set.contains(i + 1)) {
                size++;
                i++;

            }
            ans = Math.max(ans, size);
        }
        return ans;
    }
}
