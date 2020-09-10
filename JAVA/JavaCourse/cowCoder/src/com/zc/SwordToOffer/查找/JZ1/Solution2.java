/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.SwordToOffer.查找.JZ1;/*
 *@Author:
 *@CreateTime:2020-05-23-34
 *@description:在一个二维数组中（每个一维数组的长度相同），
 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

//164ms 内存:18592k
//二分法--非递归方法
public class Solution2 {
    public boolean Find(int target, int [][] array) {
        for(int row=0;row<array.length;row++){
            int left=0;//左下标初始值
            int right=array[row].length-1;//右下标初始值
            while(left<=right){
            int mid=(left+right)/2;//中间位置
           if(target>array[row][mid]){
               left=mid+1;
           }else if(target<array[row][mid]){
               right=mid-1;
           }else if(target==array[row][mid]){
               return true;
           }
        }}
   return false;
    }
}
