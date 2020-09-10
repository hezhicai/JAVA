package com.zc.contest;

import java.util.Scanner;

public class test01 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        int [] a=new int[n];
        int sum=0;
        for (int i = 0; i < n; i++) {
           a[i]= sc.nextInt();
           if(a[i]<60){
               sum+=200;
           }
        }
        System.out.println(sum);
    }
}
