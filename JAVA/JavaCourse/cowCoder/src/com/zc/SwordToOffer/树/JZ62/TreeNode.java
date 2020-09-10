package com.zc.SwordToOffer.树.JZ62;
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
    //1.添加结点
    public void add(TreeNode node){
        if(node==null){
            return;
        }
        //1.如果node小于当前结点
        //1.1如果当前节点的左节点不为空 则将节点添加进去
        //1.2为空的化  则向左递归
        if(node.val<this.val){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }
        }
        //2.node大于当前节点
        //2.1果当前节点右孩为不空 添加
        //2.2 为空则 向右递归
        if(node.val>this.val){
            if(this.right==null){
                this.right=node;
            }else{
                this.right.add(node);
            }
        }
    }
}