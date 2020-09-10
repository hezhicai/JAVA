package BST;

public class Demo {
    public static void main(String[] args) {
        //写一个数组
        int [] arr={2,4,1,7,3,9};
        //创建一个二叉排序树对象
        BinarySortedTree bin=new BinarySortedTree();
        //1.把数组内的数 转变为二叉排序树
        for (int i : arr) {
            bin.addNode(new Node(i));
        }
        //2.遍历二叉排序树
        System.out.println("二叉排序树的排序：");
        bin.midListNode(bin.root);//1	2	3	4	7	9
        //3.查找目标节点
        System.out.println("要查找的值为：");
        System.out.println(bin.search(7).value);//7
        //4.查找目标节点的父亲
        System.out.println("要查找的值的父亲为：");
        System.out.println(bin.searchParent(7).value);//4
        /*//5.1删除叶子节点 -->并将结果打印出来
        bin.deleteLeaf(3);
        System.out.println("删除叶子节点后的二叉排序树的排序：");
        bin.midListNode(bin.root);//1	2	4	7	9*/
        /*//5.2删除只有一个孩子的节点-->并将
        bin.delete(7);
        System.out.println("删除只有一个孩子的节点的二叉排序树的排序：");
        bin.midListNode(bin.root);//1	2	3	4	9*/
        //5.3删除 有两个孩子的节点 4
        bin.delete(4);
        System.out.println("删除有两个个孩子的节点的二叉排序树的排序：");
        bin.midListNode(bin.root);//1	2	3	7	9
    }
}
