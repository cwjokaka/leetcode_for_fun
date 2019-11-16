package com.company.easy;

import java.util.Stack;

public class Q_0020_ValidParentheses {

    public static void main(String[] args) {
        System.out.println(new Q_0020_ValidParentheses().isValid("(){}[]"));

    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false;
            } else if (c == '}' && stack.pop() != '{') {
                return false;
            } else if (c == ']' && stack.pop() != '[') {
                return false;
            } else if (c == ')' && stack.pop() != '(') {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
