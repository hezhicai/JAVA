/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.SwordToOffer.链表.JZ3;/*
 *@Author:
 *@CreateTime:2020-05-14-55
 *@description:
 */
public class
singleLinkedList {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private ListNode head = new ListNode(0);

    //返回头节点
    public ListNode getHead() {
        return head;
    }
    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(ListNode ListNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        ListNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = ListNode;
    }
}