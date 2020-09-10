package com.zc.SwordToOffer.递归.JZ8;
//一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
//贪心
/*思路:因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
跳1级，剩下n-1级，则剩下跳法是f(n-1)
跳2级，剩下n-2级，则剩下跳法是f(n-2)
跳n级，一种跳法
所以f(n)=f(n-1)+f(n-2)+...+f(1)+1*/
public class Solution {
    public int JumpFloorII(int target) {
        if(target==1){
            return 1;
        }
        if(target>1){
            int sum=1;
            for(int i=target-1;i>0;i--){
                sum+=JumpFloorII(i);
            }
            return sum;
        }
        return -1;
    }
}
