package com.zc.contest.testqz;
import java.util.Scanner;
//咒语
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//
        int day = sc.nextInt();//咒语天数
        int[] arr = new int[day];//记录次数
        int count = 0;//
        for (int k = 0; k < day; k++) {
            arr[k] = sc.nextInt();//6 6
        }
        for (int i = 0; i < arr.length; i++) {
            count = 0;
            for (int j = 1; j <= arr[i]; j++) {
                if (getFactors(j) % 2 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    //输入一个数，输出这个数的所有因子，并返回因子的个数
    public static int getFactors(int n) {
        int count1 = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                count1++;
            }
        }
        return count1;
    }
}

