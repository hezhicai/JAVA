package com.zc.SwordToOffer.字符串.JZ53;

public class Demo {
    public static void main(String[] args) {
        Solution s=new Solution();
        final boolean numeric = s.isNumeric("123.45e+6"
              .toCharArray());
        System.out.println(numeric);
    }
}
