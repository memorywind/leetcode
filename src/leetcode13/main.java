package leetcode13;

import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        System.out.println(romanToInt("XXVII"));
    }

    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int result = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            Integer v = map.get(c);
            if (i < n - 1 && v < map.get(s.charAt(i + 1))) {
                result = result - v ;
            } else {
                result += v;
            }
        }
        return result;
    }
}
