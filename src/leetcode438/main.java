package leetcode438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
        String p = "abcdddeffggggggggggg";
        Map<Character, Integer> map = getCount(p);
        System.out.println(map);
    }



    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = p.length();
        // 统计字符个数
        Map<Character, Integer> count = getCount(p);
        for (int i = 0; i <= s.length()-n; i++) {
            String substring = s.substring(i, i+n);
            Map<Character, Integer> count1 = getCount(substring);
            if (count1.equals(count)) {
                ans.add(i);
            }
        }
        return ans;
    }

    private static Map<Character, Integer> getCount(String p) {

        int n = p.length();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = p.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                continue;
            }
            map.put(c, 1);
        }
        return map;
    }
}
