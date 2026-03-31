package leetcode438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class demo {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int L = 0;
        Map<Character, Integer> map1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) + 1);
            L = i - p.length() + 1;
            if (L >= 0) {
                if (map1.equals(map)) {
                    ans.add(L);
                }
                map1.put(s.charAt(L), map1.get(s.charAt(L)) - 1);
                if(map1.get(s.charAt(L)) == 0) {
                    map1.remove(s.charAt(L));
                }
            }
        }
        return ans;
    }
}
