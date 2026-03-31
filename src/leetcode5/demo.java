package leetcode5;

public class demo {
    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] arr = s.toCharArray();
        int n = arr.length;
        int startIndex = 0; //最长回文字串的开始下标
        int length = 1; //最长回文字串的长度

        boolean[][] dp = new boolean[n][n]; // dp[i][j], 下标中的字符串如果是回文就是true，否则就是false ,表示字符串从下标i到j是否是回文

        // 先填充主对角线
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        // 填充主对角线右边的对角线,
        for (int j = 1; j < n; j++) {
            dp[j - 1][j] = arr[j - 1] == arr[j]; // 判断字符串长度为2的情况，从字符串下标1开始判断是否和前一个字符相等
            if (dp[j - 1][j]) {
                startIndex = j - 1;
                length = 2;
            }
        }

        for (int j = 2; j < n; j++) { // 字符串长度大于2时，左边从第一个字符开始，右边从2开始判断到右边的前一个字符
            for (int i = 0; i < j - 1; i++) {
                if (dp[i + 1][j - 1] && arr[i] == arr[j]) { // 保证字符串的两端的字符相等，且向内走一个的字符串也是回文
                    if (j - i + 1 > length) {
                        startIndex = i;
                        length = j - i + 1;
                    }
                    dp[i][j] = true;
                }
            }
        }
        return s.substring(startIndex, startIndex + length);
    }
}
