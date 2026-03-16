package leetcode3;

import java.util.HashMap;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String s = "ab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int longest = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            longest = Math.max(longest, i - left + 1);
        }
        return longest;
    }
}
