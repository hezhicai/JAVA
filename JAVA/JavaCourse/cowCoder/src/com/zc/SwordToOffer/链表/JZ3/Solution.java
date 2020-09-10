/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.SwordToOffer.链表.JZ3;/*
 *@Author:
 *@CreateTime:2020-05-10-35
 *@description:将链表逆序-用栈的方式
 */
import java.util.ArrayList;
import java.util.LinkedList;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {//头结点
       LinkedList<Integer> linkedList=new LinkedList<>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(listNode.next!=null){
            linkedList.push(listNode.next.val);
            listNode.next=listNode.next.next;
        }
        while(!linkedList.isEmpty()){
        list.add(linkedList.pop());}
        return list;
    }

}