/*
 * 版权所有(C) ,何智才,2020;
 *
 */

package com.zc.SwordToOffer.字符串.JZ2;/*
 *@Author:
 *@CreateTime:2020-05-22-33
 *@description:全部替换的方法
 append:增加的意思
 */

public class Solution {
    public String replaceSpace(StringBuffer str) {
        StringBuffer newstr=new StringBuffer();//new 一个空的字符串用来接收新的字符串结果
        if(str==null){
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newstr.append('%');
                newstr.append('2');
                newstr.append('0');
            }else{
                newstr.append(str.charAt(i));
            }
        }
        return newstr.toString();
    }
}