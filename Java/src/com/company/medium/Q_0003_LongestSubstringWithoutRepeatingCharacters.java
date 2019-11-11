package com.company.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 返回最长无重复字符的子串长度
 */
public class Q_0003_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String[] tests = {"abcabcbb", "bbbbb", "pwwkew"};
        for (String test : tests) {
            System.out.println(new Q_0003_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(test));
        }
    }

    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0, right = 0;
        // key: 字符, value: 该字符最后出现的下标位置
        Set<Character> cs = new HashSet<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            if (cs.contains(c)) {
                cs.remove(s.charAt(left++));
            } else {
                cs.add(c);
                right++;
                maxLen = Math.max(maxLen, right - left);
            }
        }
        return maxLen;
    }

}
