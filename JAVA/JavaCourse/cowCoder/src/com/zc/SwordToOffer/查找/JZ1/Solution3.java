/*
 * 版权所有(C) ,何智才,2020;
 *
 */
package com.zc.SwordToOffer.查找.JZ1;/*
 *@Author:zc
 *@CreateTime:2020-05-23-34
 *@description:在一个二维数组中（每个一维数组的长度相同），
 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
//用时 179ms  内存17232k
//二分法--非递归方法
public class Solution3 {
    public boolean Find(int target, int[][] array) {
        int  row=0;//行号
        while(row<array.length){
        if(binarySearch(array[row],0,array[row].length-1,target)){
            return  true;
        }else {
            row++;
        } }
        return false;
    }
//递归二分查找 ---  一维数组
    public static boolean binarySearch(int[] arr, int left, int right, int findVal) {
        // 当 left > right 时，说明递归整个数组，但是没有找到
        if (left > right) {
            return false;
        }
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        if (findVal > midVal) { // 向 右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) { // 向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {

            return true;
        }
    }
}