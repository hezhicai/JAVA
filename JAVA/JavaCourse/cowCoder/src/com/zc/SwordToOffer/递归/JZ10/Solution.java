package com.zc.SwordToOffer.递归.JZ10;

public class Solution {
    public int RectCover(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        if(target>2){
            return RectCover(target-1)+RectCover(target-2);
        }
        return 0;
    }
}
