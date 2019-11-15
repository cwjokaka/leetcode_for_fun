package com.company.easy;

/**
 * 最长公共前缀
 */
public class Q_0014_LongestCommonPrefix {

    public static void main(String[] args) {
        String[][] strss = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"}
        };
        for (String[] strs : strss) {
            System.out.println(new Q_0014_LongestCommonPrefix().longestCommonPrefix(strs));
        }
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        int curIndex = 0;
        String firstStr = strs[0];
        while (curIndex < firstStr.length()) {
            for (int i=1; i<strs.length; i++) {
                char curChar = firstStr.charAt(curIndex);
                if (curIndex == strs[i].length() || strs[i].charAt(curIndex) != curChar) {
                    return firstStr.substring(0, curIndex);
                }
            }
            curIndex++;
        }
        return firstStr;
    }

}
