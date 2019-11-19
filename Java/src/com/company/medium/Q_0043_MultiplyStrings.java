package com.company.medium;

public class Q_0043_MultiplyStrings {

    public static void main(String[] args) {
        System.out.println(new Q_0043_MultiplyStrings().multiply("123", "456"));
//        System.out.println(new Q_0043_MultiplyStrings().stringSum("498828660196", "840477629533"));
    }

    public String multiply(String num1, String num2) {
        String sum = "0";
        StringBuilder outerOffset = new StringBuilder();
        for (int i=num1.length()-1; i>=0; i--) {
            int cur1 = num1.charAt(i) - '0';
            StringBuilder innerOffset = new StringBuilder();
            String innerSum = "0";
            int carry = 0;
            for (int j=num2.length()-1; j>=0; j--) {
                int cur2 = num2.charAt(j) - '0';
                int tempSum = cur1 * cur2 + carry;
                carry = tempSum / 10;
                int thisLoc = tempSum % 10;
                innerOffset.insert(0, thisLoc);
//                innerSum = innerSum + thisLoc * innerOffset;        // 可能溢出
                innerSum = stringSum(innerSum, innerOffset.toString());
//                innerOffset *= 10;                                  // 可能溢出
                innerOffset.append("0");
            }
            // 还要加上最后的进位
//            innerSum += carry * innerOffset;// 可能溢出
//            innerOffset.insert(0, carry);
            innerSum = stringSum(innerSum, innerOffset.toString());
            // 竖式乘法的相加环节
//            sum = sum + (outerOffset * innerSum);// 可能溢出
            sum = stringSum(sum, innerSum + outerOffset.toString());
//            outerOffset;// 可能溢出
            outerOffset.append("0");
        }
        return String.valueOf(sum);
    }

    // string两数相加
    private String stringSum(String num1, String num2) {
        if (num1.length() > num2.length()) {
            String temp;
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i=num1.length()-1; i>=0; i--) {
            int cur1 = num1.charAt(i) - '0';
            int cur2 = num2.charAt(i) - '0';
            int sum = cur1 + cur2 + carry;
            carry = sum / 10;
            int curLoc = sum % 10;
            res.insert(0, curLoc);
        }
        if (carry > 0 && num1.length() == num2.length()) {
            res.insert(0, carry);
        } else {
            for (int i=num2.length()-num1.length()-1; i>=0 && carry>0; i--) {
                int cur = num2.charAt(i) - '0';
                int sum = cur + carry;
                carry = sum / 10;
                int curLoc = sum % 10;
                res.insert(0, curLoc);
            }
        }
        return res.toString();
    }

}
