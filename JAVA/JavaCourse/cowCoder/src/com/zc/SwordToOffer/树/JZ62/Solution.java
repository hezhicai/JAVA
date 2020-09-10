package com.zc.SwordToOffer.树.JZ62;
//给定一棵二叉搜索树
//请找出其中的第k小的结点。例如（5，3，7，2，4，6，8）中
// 按结点数值大小顺序第三小结点的值为4。
public class Solution {
    int index = 0;
    TreeNode res;
    TreeNode KthNode(TreeNode pRoot, int k) {
        find(pRoot, k);
        return res;
    }
    public void find(TreeNode node, int k) {
        if (node == null || index > k) {
            return;
        }
        //向左找--递归
        find(node.left, k);
        index++;
        if (index == k) {
            res = node;
        }
        //向右找--递归
        find(node.right, k);
    }

}
