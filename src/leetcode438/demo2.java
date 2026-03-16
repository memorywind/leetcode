package leetcode438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class demo2 {

    public static List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();
        if (sLen < pLen) return ans;

        // 因为题目限定字符串只包含小写字母，所以可以用长度为26的数组
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a'] = pCount[s.charAt(i) - 'a'] + 1;
        }

        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a'] = sCount[s.charAt(i) - 'a'] + 1;
        }
        if (Arrays.equals(pCount, sCount)) {
            ans.add(0);
        }
        // 滑动窗口
        for (int i = pLen; i < sLen; i++) {
            // 移除窗口最左边的字符（i - pLen）
            sCount[s.charAt(i - pLen) - 'a']--;
            // 加入窗口最右边的字符（i）
            sCount[s.charAt(i) - 'a']++;
            // 当前窗口起始索引为 i - pLen + 1
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i - pLen + 1);
            }
        }
        return ans;
    }
}