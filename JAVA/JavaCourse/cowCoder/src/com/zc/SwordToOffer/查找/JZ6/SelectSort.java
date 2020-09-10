package com.zc.SwordToOffer.查找.JZ6;

public class SelectSort {
    public static void selectSort(int [] array) {
        //如果数组的长度为零 返回0
        if (array.length == 0) {
            return;
        }
        //从头到尾进行排序--选择最小值
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;//最小值下标
            int min = array[index];//最小值
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];//保存最小值
                    index = j;
                }
            }
            if (i != index) {//自己定义的最小值不是最小值 进行交换
                array[index]=array[i];
                array[i] = min;
            }
        }
    }
}
