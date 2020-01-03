package com.company.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q_0155_MinStack {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(3);
        minStack.push(2);
        minStack.push(9);
        System.out.println(minStack.getMin());
        minStack.push(2);
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    public static class MinStack {

        Stack<Integer> stack = new Stack<>();
        Stack<Integer> minRecord = new Stack<>();

        public void push(int x) {
            stack.push(x);
            if (minRecord.isEmpty() || minRecord.peek() >= x) {
                minRecord.push(x);
            }
        }

        public void pop() {
            int pop = stack.pop();
            if (minRecord.peek() == pop) {
                minRecord.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minRecord.peek();
        }
    }

}
