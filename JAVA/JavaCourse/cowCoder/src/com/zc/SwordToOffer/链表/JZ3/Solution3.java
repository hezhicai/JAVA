/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.SwordToOffer.链表.JZ3;/*
 *@Author:
 *@CreateTime:2020-05-19-56
 *@description:递归法
 */
import java.util.ArrayList;
public class Solution3 {
    ArrayList<Integer> list=new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
       ListNode temp=listNode;
       if(temp!=null){
           if(temp.next!=null){
               printListFromTailToHead(temp.next);
           }
           list.add(temp.val);
       }
       return list;
    }
}
