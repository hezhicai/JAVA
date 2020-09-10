package BST;
//结点类
public class Node {
    int value;
     Node left;
     Node right;
    public Node(int value){
        this.value=value;
    }
    //1.添加结点
    public void add(Node node){
        if(node==null){
            return;
        }
        //1.如果node小于当前结点
        //1.1如果当前节点的左节点不为空 则将节点添加进去
        //1.2为空的化  则向左递归
        if(node.value<this.value){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }
        }
        //2.node大于当前节点
        //2.1果当前节点右孩为不空 添加
        //2.2 为空则 向右递归
        if(node.value>this.value){
            if(this.right==null){
                this.right=node;
            }else{
                this.right.add(node);
            }
        }
    }
    //2.中序遍历  打印出排序树的顺序
    public void midList(){
        //先左树
        if(this.left!=null){
            this.left.midList();
        }
        //中
        System.out.printf("%d\t",this.value);
        //后右树
        if(this.right!=null){
            this.right.midList();
        }
    }
    //3.查找值为value的结点
    public Node search(int value){
        //1.如果当前结点的值为value直接返回
        if(this.value==value){
            return this;
        }
        //2.value大于当前结点的值
        if(value>this.value){
            //2.1.如果当前结点的右孩不为空-->向右孩子递归
            if(this.right!=null){
                return this.right.search(value);
            }
        }
        //3.value小于当前结点的值
        if(value<this.value){
            //3.1如果当前结点的左孩不为空-->向左孩递归
            if(this.left!=null){
                return this.left.search(value);
            }
        }
        return null;
    }
    //4.查找值为valued的父亲节点
    public Node searchParent(int value){
        //1.如果当前节点的左孩的值等于value或者右孩的值等于value则返回this（父节点）
        if(this.left!=null&&this.left.value==value ||this.right!=null&&this.right.value==value){
            return this;
        }
         //2.value大于当前节点的值，且当前节点的右孩不为空，则进行右子树的查找
        if(value>this.value){
            if (this.right!=null){
                return this.right.searchParent(value);
            }
        }
        //3.value小于当前节点的值，且当前节点的左孩不为空，则进行左子树的查找
        if(value<this.value){
            if (this.left!=null){
                return this.left.searchParent(value);
            }
        }
        return null;
    }

}
