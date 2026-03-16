package leetcode14;

public class main {
    public static void main(String[] args) {

    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0){
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++){
            ans = longestCommonPrefix(ans, strs[i]);
            if(ans.length() == 0){
                break;
            }
        }
        return ans;
    }
    public static String longestCommonPrefix(String str1, String str2) {
        int size = Math.min(str1.length(), str2.length());
        int longest = 0;
        for (int i = 0; i < size; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);
            if (c1 != c2) {
                break;
            }else {
                longest++;
            }
        }
        return str1.substring(0, longest);
    }
}
