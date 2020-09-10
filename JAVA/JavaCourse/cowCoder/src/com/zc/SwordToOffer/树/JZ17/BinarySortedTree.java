package com.zc.SwordToOffer.树.JZ17;
//顺序 存储二叉树
public class BinarySortedTree {
    private int [] arr;
    //1.节点的添加
   public BinarySortedTree(int [] arr){
       this.arr=arr;
   }
   //方法重载
   public  void preOrder(){
       preOrder(0);
   }
   //前序遍历
    public void preOrder(int index){
       if (arr.length==0||arr==null){
           System.out.println(" 空 空 链 表！");
       }
        System.out.println(arr[index]);//0-->1-->3-->4-->2-->5-->6
        if (2*index+1<arr.length){
               preOrder(2*index+1);
        }
        if (2*index+2<arr.length)
        {
            preOrder(2*index+2);
        }
   }
}
