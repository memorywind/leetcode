package leetcode49;

import java.util.*;

public class demo {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            String s = new String(charArray);
            if (map.containsKey(s)) {
                map.get(s).add(temp);
            }else{
                List<String> list = new ArrayList<>();
                list.add(temp);
                map.put(s,list);
            }
        }
        ans.addAll(map.values());
        return ans;
    }
}
