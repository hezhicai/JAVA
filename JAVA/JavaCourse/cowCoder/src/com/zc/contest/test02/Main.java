package com.zc.contest.test02;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int i=0;
        if(i<n){
            arr[i] = sc.nextInt();
            i++;
        }
        bubbleSort(arr);
    }
    // 将冒泡排序算法，封装成一个方法
    public static void bubbleSort(int[] arr) {
        int temp = 0; // 临时变量
        boolean flag = false; // 标识变量，表示是否进行过交换
        int i = 0;
        int count=0;
        for (i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    count++;
                    if(count==1){break;}
                }
            }
            if (!flag) { // 在一趟排序中，一次交换都没有发生过
                break;
            } else {
                flag = false; // 重置flag!!!, 进行下次判断
            }
        }
        System.out.println(i);
    }
}
