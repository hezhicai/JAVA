package com.zc.SwordToOffer.字符串.JZ43;




/**
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution {

    public String LeftRotateString(String str,int n) {
        if(str.length() == 0){//进行判空
            return str;
        }
        StringBuilder sb=new StringBuilder();
        StringBuilder sb1=new StringBuilder(str);
        StringBuilder sb2=new StringBuilder(str);
        sb1.delete(0,n);
        sb2.delete(n,str.length());
        sb.append(sb1).append(sb2);
        return sb.toString();

    }
}
