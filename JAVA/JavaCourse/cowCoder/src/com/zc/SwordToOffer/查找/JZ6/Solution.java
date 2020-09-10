package com.zc.SwordToOffer.查找.JZ6;
/*
*把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。*/
//我用的是 选择排序的方法 确定最小值
public class Solution {
    public int minNumberInRotateArray(int [] array) {
       //如果数组的长度为零 返回0
        if(array.length==0){
            return 0;
        }
        //从头到尾进行排序--选择最小值
        int index=0;//最小值下标
        int min=array[index];//最小值
        for (int i = 1; i < array.length; i++) {
            if(array[i]<=0){return 0;}//保证每个元素大于零
            if(min>array[i]){
                min=array[i];
            }
        }
        return min;
    }
}
