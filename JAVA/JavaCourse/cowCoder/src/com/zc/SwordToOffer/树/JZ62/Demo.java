package com.zc.SwordToOffer.树.JZ62;
public class Demo {
    public static void main(String[] args) {
        //写一个数组
        int [] arr={5,3,7,2,4,6,8};
        //创建一个二叉排序树对象
        BinarySortedTree bin=new BinarySortedTree();
        //1.把数组内的数 转变为二叉排序树
        for (int i : arr) {
            bin.addTreeNode(new TreeNode(i));
        }
        Solution02 solve=new Solution02();
        TreeNode res = solve.KthNode(bin.root, 5);
        System.out.println("第5小的数是:"+res.val);
    }
}
