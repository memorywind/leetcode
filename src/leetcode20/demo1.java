package leetcode20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class demo1 {
    public boolean isValid(String s) {
        // 首先判断字符的长度是否是偶数，如果不是偶数必然不能闭合
        if (s.length() % 2 != 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false; // 这种情况说明没有入栈的，肯定不匹配
                if (map.get(c).equals(stack.peek())) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
