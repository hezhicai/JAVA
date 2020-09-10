package com.zc.SwordToOffer.字符串.JZ44;

public class Solution2 {
    public String ReverseSentence(String str) {
        StringBuilder strs= new StringBuilder();
        String regex=" ";
        String[] strings = str.split(regex);
        for (int i = strings.length-1; i >=0 ; i--) {
             strs.append(strings[i]).append(" ");
        }
        return strs.toString();
    }
}
