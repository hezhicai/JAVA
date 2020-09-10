/*
 * 版权所有(C) ,何智才,2020;
 */
package com.zc.SwordToOffer.链表.JZ3;/*
 *@Author:
 *@CreateTime:2020-05-15-32
 *@description:创建新的链表 重新排序
 */
import java.util.ArrayList;
/*public class Solution2 {
    //将单链表反转*/
   /* public ArrayList<Integer> printListFromTailTolistNode(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //定义一个辅助的指针(变量)，帮助我们遍历原来的链表
        ListNode cur = listNode.next;
        ListNode next = null;// 指向当前节点[cur]的下一个节点
        ListNode reverselistNode = new ListNode(0);
        //遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表reverselistNode 的最前端
        //动脑筋
        while(cur != null) {
            next = cur.next;//先暂时保存当前节点的下一个节点，因为后面需要使用
            cur.next = reverselistNode.next;//将cur的下一个节点指向新的链表的最前端
            reverselistNode.next = cur; //将cur 连接到新的链表上
            cur = next;//让cur后移
        }
        //将listNode.next 指向 reverselistNode.next , 实现单链表的反转
        listNode.next = reverselistNode.next;
        //将所有结点全部添加到新的链表中
        while(reverselistNode.next!=null){//如果新的链表头结点的下一个结点不为空
            list.add(reverselistNode.next.val);
            reverselistNode.next=reverselistNode.next.next;
        }
        return list;

    }
}*/

//更简便
public class Solution2 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode tmp = listNode.next;
        while(tmp!=null){
            list.add(0,tmp.val);
            tmp = tmp.next;
        }
        return list;
    }
}
