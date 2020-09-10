package com.zc.SwordToOffer.树.JZ62;
public class BinarySortedTree {
     TreeNode root;
    //1.节点的添加
    public void addTreeNode(TreeNode TreeNode){
        if(root!=null){
            root.add(TreeNode);
        }else{
            root=TreeNode;
        }
    }
}
