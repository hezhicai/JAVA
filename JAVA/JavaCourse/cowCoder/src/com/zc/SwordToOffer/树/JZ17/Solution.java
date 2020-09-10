package com.zc.SwordToOffer.树.JZ17;
//输入两棵二叉树A，B，判断B是不是A的子结构。
// （ps：我们约定空树不是任意一个树的子结构）
public class Solution {
    boolean res = false;//设置结果的初始值为false
    public boolean HasSubtree(TreeNode root1, TreeNode root2){
        if (root1 != null && root2 != null) {
            //根节点值相同  继续进行往下比较
            if (root1.val == root2.val) {
                res = theSameAs(root1, root2);//theSameAs方法查看两颗树的遍历结果是否相同
            }
            // 如果 结果 为false 没找到向左找
            if (res == false) {
                res = HasSubtree(root1.left, root2);
            }
            //向右找
            if (res == false) {
                res = HasSubtree(root1.right, root2);
            }
        }
        return res;
    }
    //递归检查 两棵树的每个节点值 是否相同
    public boolean theSameAs(TreeNode node1,TreeNode node2) {
//---------三者的顺序不能反了
        //子树先结束   正确
        if (node2 == null) {
            return true;
        }
        //母树 先结束 错误
        if (node1 == null) {
            return false;
        }
        //有结点 不同 就返回
        if (node1.val != node2.val) {
            return false;
        }
        //继续递归检查
            return theSameAs(node1.left, node2.left) && theSameAs(node1.right, node2.right);
    }
}

