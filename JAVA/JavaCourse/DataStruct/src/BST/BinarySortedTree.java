package BST;
public class BinarySortedTree {
     Node root;
    //1.节点的添加
    public void addNode(Node node){
        if(root!=null){
            root.add(node);
        }else{
            root=node;

        }
    }
    //2.中序遍历
    public void midListNode(Node node){
        if(root!=null){
            root.midList();
        }else{
            System.out.println("二叉树为空！！！");
        }
    }
    //3.1目标结点的查找
    public Node search(int value){
        //如果根节点不为空 进行查找
        if(root!=null){
           return  root.search(value);
        }
         return null;
    }
    //3.2目标节点的父节点查找
    public Node searchParent(int value){
        //如果根节点不为空 进行查找
        if(root!=null){
            return  root.searchParent(value);
        }
        return null;
    }
    //4.删除节点 三种情况----------------------------
    public void delete(int value){
        // 1.找到目标结点targetNode
        Node targetNode = search(value);
        //2.找到targrtNode的父亲parentNode
        Node parent = searchParent(value);
        //3.删除值为value的叶子节点
        //3.1叶子是父亲的左孩？parentNode.left=null:parentNode.right=null
        if(targetNode.left==null&&targetNode.right==null){
            if(targetNode==parent.left){parent.left=null;}
            if(targetNode==parent.right){parent.right=null;}
        }
        //4删除只有一个孩子的节点
        // 4.1如果孩子是目标结点的左孩：目标结点是父亲的左孩？parentNode.left=targetNode.left:parentNode.righ=targetNode.left
        if (targetNode.left != null&&targetNode.right==null) {
            if (targetNode == parent.left) {
                parent.left = targetNode.left;
            }
            if (targetNode == parent.right) {
                parent.right = targetNode.left;
            }
        }
        //4.2如果孩子是目标结点的右孩：目标结点是父亲的左孩？parentNode.left=targetNode.right:parentNode.righ=targetNode.right
        if (targetNode.right != null&&targetNode.left==null) {
            if (targetNode == parent.left) {
                parent.left = targetNode.right;
            }
            if (targetNode == parent.right) {
                parent.right = targetNode.right;
            }
        }
        //5删除有两个孩子的节点
        //5.1寻找当前结点右子树中最小值的结点并将最小值保存在temp中，再删掉这个节点,将temp赋给当前节点targetNode.value=temp
        if(targetNode.right!=null&&targetNode.left!=null){
            int temp=deleteRightTreeMin(targetNode.right);//
            targetNode.value=temp;
        }
    }
    //《寻找右树中的最小值 删除该节点 并返回该值》
    public int deleteRightTreeMin(Node node){
        Node target=node;//目标节点
        //如果节点为空 则返回
        if(node==null){
            return -1;
        }
        //向左一直找
        while(node.left!=null){
            target=node.left;
        }
        int val=target.value;
        delete(val);
        return val;
    }
}
