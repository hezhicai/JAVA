package com.zc.SwordToOffer.链表.JZ5;

public class Demo {
    public static void main(String[] args) {
        Solution02 solu=new Solution02();
        solu.push(1);
        solu.push(2);
        solu.push(3);
        solu.push(4);
        for (int i = 0; i < 4; i++) {
            System.out.println(solu.pop());
        }
    }
}
