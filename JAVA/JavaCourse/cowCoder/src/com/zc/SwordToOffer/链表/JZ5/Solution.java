package com.zc.SwordToOffer.链表.JZ5;

import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    public void push(int node) {
        stack1.push(node);
    }
    public int pop() {//栈2只是作为出队的桥梁作用  中间值
        //1.栈1入栈2
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //2.弹出一个栈2的元素 作为本次的弹出值
        Integer element = stack2.pop();
        //3.栈2的元素重新入栈1
        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return element;
    }
}
