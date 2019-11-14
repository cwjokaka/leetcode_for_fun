package com.company.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串转整数
 */
public class Q_0008_StringToIntegerAtoi {

    private static final Map<Character, Integer> tran = new HashMap<>();
    static {
        tran.put('0', 0);
        tran.put('1', 1);
        tran.put('2', 2);
        tran.put('3', 3);
        tran.put('4', 4);
        tran.put('5', 5);
        tran.put('6', 6);
        tran.put('7', 7);
        tran.put('8', 8);
        tran.put('9', 9);
    }

    public static void main(String[] args) {
        String[] tests = {"-2147483649", "42", "   -42", "4193 with words", "words and 987", "-91283472332"};
        for (String test : tests) {
            System.out.println(new Q_0008_StringToIntegerAtoi().myAtoi(test));
        }
    }

    public int myAtoi(String str) {
        if ("".equals(str)) {
            return 0;
        }
        int res = 0;
        int index = 0;
        int flag = 1;
        int len = str.length();
        // 先跳过所有空格
        while (index < len && str.charAt(index) == ' ') {
            index++;
        }
        if (index == len) {
            return 0;
        }
        // 检测第一个非空字符
        char firstC = str.charAt(index);
        if (firstC == '-') {
            flag = -1;
            index++;
        } else if (firstC == '+') {
            flag = -1;
            index++;
        } else if (!isNum(firstC)) {
            return 0;
        }

        for (int i=index; i<len; i++) {
            char c = str.charAt(i);
            if (isNum(c)) {
                int nextNum = tran.get(c);
                // 溢出判断
                if(flag>0 && (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && nextNum > 7)))
                    return Integer.MAX_VALUE;
                if(flag<0 && (-res < Integer.MIN_VALUE/10) || (-res == Integer.MIN_VALUE/10 && nextNum > 8))
                    return Integer.MIN_VALUE;
                res = res * 10 + nextNum;
            } else {
                return res * flag;
            }
        }
        return res * flag;
    }

    private boolean isNum(char c) {
        return c >= 48 && c<=57;
    }

}
