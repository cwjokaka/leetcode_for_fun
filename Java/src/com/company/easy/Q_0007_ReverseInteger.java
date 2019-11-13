package com.company.easy;

/**
 * 整数反转
 */
public class Q_0007_ReverseInteger {

    public static void main(String[] args) {
        int[] tests = {123, 321, 12345, Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int test : tests) {
//            System.out.println(test);
            System.out.println(new Q_0007_ReverseInteger().reverse(test));
        }

    }

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (isOverflow(res, pop)) {
                return 0;
            }
            res = res * 10 + pop;
        }
        return res;
    }

    private boolean isOverflow(int res, int pop) {
        return Integer.MAX_VALUE / 10 < res
                || (Integer.MAX_VALUE / 10 == res && pop > 7)
                || Integer.MIN_VALUE / 10 > res
                || Integer.MIN_VALUE / 10 == res && pop < -8;
    }


}
