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

//时间：177ms  内存17328k
//方法一 利用对角线
public class Solution {
    public boolean Find(int target, int [][] array) {
             int row=array.length;//行数
            int col=array[row-1].length;//列数
            int i=0,j=col-1;//从对角线的右上方开始查找
        while(i<row&&j>=0){//遍历到对角线的左下方
            if(target>array[i][j]){
                i++;//目标在对角线的右方
            }
            else if(target<array[i][j]){
                j--;//目标在对角线的左方
            }else{
                return true;//找到目标了
            }
        }
        return false;//未找到
    }
}
