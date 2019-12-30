package com.company.easy;

/**
 *
 */
public class Q_0122_BestTimeToBuyAndSellStock_2 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Q_0122_BestTimeToBuyAndSellStock_2().maxProfit(prices));
    }

    // 峰谷法
//    public int maxProfit(int[] prices) {
//        int point = 0;
//        int valley = 0;
//        int peak = 0;
//        int result = 0;
//        while (point < prices.length - 1) {
//            while (point < prices.length - 1 && prices[point] > prices[point+1]) {
//                point++;
//            }
//            valley = prices[point];
//            while (point < prices.length - 1 && prices[point] < prices[point+1]) {
//                point++;
//            }
//            peak = prices[point];
//            result += peak - valley;
//        }
//        return result;
//    }

    // 峰谷，一次循环
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i] < prices[i+1]) {
                result += prices[i+1] - prices[i];
            }
        }
        return result;
    }

}
