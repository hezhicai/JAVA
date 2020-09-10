/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.SwordToOffer.查找.JZ1;/*
 *@Author:
 *@CreateTime:2020-05-00-07
 *@description:在一个二维数组中（每个一维数组的长度相同），
 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

public class Demo {
    public static void main(String[] args) {
        int[][] arrayTest = {{1, 2, 3, 4}, {2, 3, 4, 5}, {3, 4, 5, 6}, {4, 5, 6, 7}};
        int targetTest = 7;
       Solution2 solution=new Solution2();

       if(solution.Find(targetTest,arrayTest)){
           System.out.println("存在");
       }else{
           System.out.println("不存在");
       }
    }
}
