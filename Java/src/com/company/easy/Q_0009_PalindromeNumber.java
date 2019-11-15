package com.company.easy;

/**
 * 回文数
 */
public class Q_0009_PalindromeNumber {

    public static void main(String[] args) {
        int[] tests = {121, 101, -121, 10, 11};
        for (int num : tests) {
            System.out.println(new Q_0009_PalindromeNumber().isPalindrome(num));
        }
    }

    public boolean isPalindrome(int x) {
        // 排除特殊情况
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int rev = 0;
        // 检测rev长度是否快超过x
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return rev == x || rev/10 == x;
    }

}
