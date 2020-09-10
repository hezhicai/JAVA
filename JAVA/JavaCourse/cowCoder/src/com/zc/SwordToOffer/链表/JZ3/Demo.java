/*
 */
package com.zc.SwordToOffer.链表.JZ3;/*
 *@Author:
 *@CreateTime:2020-05-10-59
 *@description:输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) {
        ListNode node1=new ListNode(100);
        ListNode node2=new ListNode(200);
        ListNode node3=new ListNode(300);
        singleLinkedList list=new singleLinkedList();
        list.add(node1);
        list.add(node2);
        list.add(node3);

        Solution3 solution = new Solution3();
        ArrayList<Integer> list2 = solution.printListFromTailToHead(list.getHead().next);
        for (Integer i : list2) {
            System.out.println(i);
      }
    }
}
