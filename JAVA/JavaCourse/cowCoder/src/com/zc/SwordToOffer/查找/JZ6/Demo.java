package com.zc.SwordToOffer.查找.JZ6;
public class Demo {
    public static void main(String[] args) {
        int []arr={5,4,6,9,7,8};
        Solution s=new Solution();
        System.out.println(s.minNumberInRotateArray(arr));
       SelectSort.selectSort(arr);
        for (int a:arr){//排序
            System.out.printf("%d\t",a);
        }
    }
}
