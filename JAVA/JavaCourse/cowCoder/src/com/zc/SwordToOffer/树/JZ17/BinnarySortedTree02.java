package com.zc.SwordToOffer.树.JZ17;

public class BinnarySortedTree02 {
    TreeNode root;
    public  void addNode(TreeNode node){
        if (root!=null){
            root.add(node);
        }else{
            root=node;
        }
    }
}
