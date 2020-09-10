package com.zc.SwordToOffer.链表.JZ5;

import java.util.Stack;

public class Solution02 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {//栈2作为出对队列
        //1.当栈2为空时 把栈1的元素 进入栈2
        while (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}