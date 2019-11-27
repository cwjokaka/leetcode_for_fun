package com.company.easy;

/**
 * 买卖股票的最佳时机
 */
public class Q_0121_BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Q_0121_BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    /**
     * 一次遍历
     * time: O(N)
     * space: O(1)
     */
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (minPrice > price) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }
        return maxProfit;
    }

}
