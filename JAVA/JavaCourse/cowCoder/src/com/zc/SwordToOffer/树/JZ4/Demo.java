/*
 * 版权所有(C) ,何智才,2020;
 */
package com.zc.SwordToOffer.树.JZ4;/*
 *@Author:
 *@CreateTime:2020-05-22-56
 *@description:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Demo {
    public static void main(String[] args) {
        int [] pre={1,2,4,7,3,5,6,8};
        int [] in={4,7,2,1,5,3,8,6};
        Solution solution=new Solution();
        TreeNode root=solution.reConstructBinaryTree(pre, in);//根结点
        PrintBinaryTree print=new PrintBinaryTree();
        print.printLast(root);//打印后序遍历
        System.out.println();
        print.printLevel(root);

    }
}
