/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.SwordToOffer.字符串.JZ2;/*
 *@Author:
 *@CreateTime:2020-05-22-56
 *@description:请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */

public class Demo {
    public static void main(String[] args) {
        Solution solution=new Solution();
        StringBuffer str=new StringBuffer("We Are Happy!");
        System.out.println(solution.replaceSpace(str));
    }
}
