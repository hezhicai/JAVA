package com.zc.SwordToOffer.字符串.JZ54;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */

public class Solution {
    HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>();
    LinkedList<Character> list = new LinkedList<Character>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (hashMap.containsKey(ch)) {//ch多次出现   记录为 非1
            hashMap.put(ch, -1);
        } else {//第一次 出现  记录 值为 1
            hashMap.put(ch, 1);
            list.offer(ch);//先来先服务
        }
    }

    /**
     * 如果当前字符流没有存在出现一次的字符，返回#字符。
     *
     * @return #
     */
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        for (char key : list) {
            if (hashMap.get(key) == 1) {//第一个只出现一次
                return key;
            }
        }
        return '#';
    }
}
