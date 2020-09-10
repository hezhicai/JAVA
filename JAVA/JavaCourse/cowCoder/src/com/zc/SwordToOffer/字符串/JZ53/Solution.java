package com.zc.SwordToOffer.字符串.JZ53;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Solution {
    public boolean isNumeric(char[] str) {//-.123 = -0.123，233. = 233.0，-010.1=-10.1
//        final String ss = Arrays.toString(str);//{a,b,c,d,e,f}-->[abcdef]
        String s = new String(str);//{a,b,c,d,e,f}-->abcdef
        String rex = "^[-+]?\\d*(\\.\\d*)?([eE][-+]?\\d+)?$";
        Pattern p = Pattern.compile(rex);
        final Matcher matcher = p.matcher(s);
        return matcher.matches();
    }
}
