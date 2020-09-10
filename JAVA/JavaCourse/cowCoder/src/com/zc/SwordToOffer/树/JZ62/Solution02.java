package com.zc.SwordToOffer.树.JZ62;
import java.util.LinkedList;
//通过栈的特性 将节点按从小到达 弹出
//灵活的进行入栈 出栈 当最左分支全部入栈成功 ，再进行 左中出 右进的策略
public class Solution02 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        int index = 0;//记录 弹出的个数 第k个时 停止
        TreeNode res;//保存结果
        //将链表 作为栈
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        while (pRoot != null || !list.isEmpty()) {
            //左树先入栈
            while (pRoot != null) {
                list.offer(pRoot);//头插
                pRoot = pRoot.left;
            }
            //出栈
            res = list.poll();//头删
            index++;
            if (index == k) {
                return res;
            }
            //将弹出节点的 右树 入栈  出栈-->相成左中右的順序彈出
            pRoot = res.right;
        }
        return null;
  }
}