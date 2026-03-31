package leetcode76;

import java.util.HashMap;
import java.util.Map;

public class demo {
    public String minWindow(String s, String t) {
        int L = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int valid = 0;
        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> currentMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        for (int R = 0; R < s.length(); R++) {
            char c = s.charAt(R);
            currentMap.put(c, currentMap.getOrDefault(c, 0) + 1);
            // 检查当前字符是否是目标字符且数量达到要求
            if (targetMap.containsKey(c) && currentMap.get(c).intValue() == targetMap.get(c).intValue()) {
                valid++;
            }

            // 循环检查当前哈希表是否涵盖了目标哈希表
            // 当valid等于targetMap的大小时，说明当前窗口已经涵盖了所有目标字符
            while (valid == targetMap.size()) {
                // 更新最小窗口
                if (R - L + 1 < minLen) {
                    minLen = R - L + 1;
                    start = L;
                }

                // 尝试缩小窗口
                char leftChar = s.charAt(L);
                if (targetMap.containsKey(leftChar)) {
                    if (currentMap.get(leftChar).intValue() == targetMap.get(leftChar).intValue()) {
                        valid--;
                    }
                    currentMap.put(leftChar, currentMap.get(leftChar) - 1);
                } else {
                    currentMap.put(leftChar, currentMap.get(leftChar) - 1);
                }
                L++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
