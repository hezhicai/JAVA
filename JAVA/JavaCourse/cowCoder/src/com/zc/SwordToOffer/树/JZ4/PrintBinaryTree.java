/*
 */
package com.zc.SwordToOffer.树.JZ4;/*
 *@Author:
 *@CreateTime:2020-05-23-23
 *@description:后续遍历--
 */

import java.util.LinkedList;

public class PrintBinaryTree {
    public void printLast(TreeNode root){
    if(root!=null) {
        printLast(root.left);
        printLast(root.right);
        System.out.print(" "+root.val);
    }
    }
    //层次遍历
    public void printLevel(TreeNode root){
        LinkedList<TreeNode> queue=new LinkedList<>();
        TreeNode current=null;
        queue.add(root);
        while(!queue.isEmpty()){
            current=queue.poll();//出队
            System.out.print(" "+current.val);//打印
            if(current.left!=null){
                queue.offer(current.left);//左子树入队
            }
            if(current.right!=null){
                queue.offer(current.right);//右子树入队
            }
        }

    }
}
