/*
 * 版权所有(C) ,何智才,2020;
 */
package com.zc.SwordToOffer.树.JZ4;
/*
 *@Author:zc
 *@CreateTime:2020-05-22-29
 *@description:根据所给的序列重构二叉树
 */
//import javax.swing.tree.TreeNode;

import java.util.*;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre.length==0 || in.length==0 ){//当递归完最后最后一个元素时返回空
            return null;
        }
        TreeNode root=new TreeNode(pre[0]);

        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                //左右两个子树各自递归
                root.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));//复制数组的指定长度
                root.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
        

    }
}
