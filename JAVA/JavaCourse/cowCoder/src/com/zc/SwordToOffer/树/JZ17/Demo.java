package com.zc.SwordToOffer.树.JZ17;

public class Demo {
    public static void main(String[] args) {
        Solution solve=new Solution();
        //写一个数组
        int [] arr={0,1,2,3,4,5,6};
        int [] arr2={4,5,6};
        //创建一个二叉排序树对象
        BinnarySortedTree02 bin=new BinnarySortedTree02();
        BinnarySortedTree02 bin02=new BinnarySortedTree02();
        for (int i : arr) {
            bin.addNode(new TreeNode(i));
        }
        for (int i : arr2) {
            bin02.addNode(new TreeNode(i));
        }
       Solution s=new Solution();
        System.out.println(s.HasSubtree(bin.root, bin02.root));
    }
}
