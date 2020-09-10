package com.zc.SwordToOffer.字符串.JZ45;

import java.util.TreeSet;

/**
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 */
public class Solution {
    public boolean isContinuous(int [] numbers) {
        //记录王的数量
        int count = 0;
        //TreeSet按自然顺序将抓出的牌 非重复排序
        TreeSet<Integer> treeSet = new TreeSet<>();
        //没有5张牌 不算
        if (numbers.length != 5) {
            return false;
        }
        //遍历数组，把大王，小王排除 ,非王的牌入放set
        for (int number : numbers) {
            if (number != 0) {
                treeSet.add(number);
            } else {
                count++;
            }
        }
        //判断非王的牌是否有重复,重复的话set中元素会覆盖
        if (count + treeSet.size() < 5) {
            return false;
        }
        //判断set中的差值是否<5，是：true 不是：false
        return treeSet.last() - treeSet.first() < 5;
    }

}
/**
 * 抽出的5张牌差值<5
 * 5张牌不重复（小王大王不算）
 */