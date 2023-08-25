package Test02;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class TreeNode {
        public char value; //定义每个节点存储的值
        public TreeNode left; //定义节点的左子树
        public TreeNode right;  //定义节点的右子树

        public TreeNode(char value) {
            this.value = value;
        }
    }

    public TreeNode root;//定义根节点

    public void createTree() {
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');
        TreeNode I = new TreeNode('I');
        A.left = B;
        B.left = D;
        B.right = F;
        F.left = E;
        A.right = C;
        C.left = G;
        C.right = I;
        G.right = H;
        this.root = A;

    }

    /*
     * 前序遍历（递归方式）
     * */
    public void preOrder(TreeNode root) { //前序遍历：根节点-->左子树-->右子树
        if (root == null) {
            return;
        }
        System.out.print(root.value + " ");//打印根节点
        preOrder(root.left);// 递归遍历左子树
        preOrder(root.right);// 递归遍历右子树
    }

    /*
     * 中序遍历（递归方式）
     * */
    public void inOrder(TreeNode root) {//中序遍历：左子树-->根节点-->右子树
        if (root == null) {
            return;
        }
        inOrder(root.left);// 递归遍历左子树
        System.out.print(root.value + " ");//打印根节点
        inOrder(root.right);// 递归遍历右子树
    }

    /*
     * 后序遍历（递归方式）
     * */
    public void posOrder(TreeNode root) {//后序遍历：左子树-->右子树-->根节点
        if (root == null) {
            return;
        }
        posOrder(root.left);// 递归遍历左子树
        posOrder(root.right);// 递归遍历右子树
        System.out.print(root.value + " ");//打印根节点
    }

    /*
     * 二叉树的层序遍历*/
    public  void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();//层序遍历利用队列性质：先进先出 层序遍历二叉树
        if(root == null){
            return ;
        }
        queue.offer(root);
        while(!queue.isEmpty()){//当队列为空时，二叉树层序遍历就完成了
            TreeNode cur = queue.poll(); //当队列不为空时，就把队头的节点赋值给cur，队头节点出队列并打印cur节点数据域
            System.out.print(cur.value+" ");
            if(cur.left != null){ //节点的左子树不为空时，入队列
                queue.offer(cur.left);
            }
            if(cur.right != null){  //节点的右子树不为空时，入队列
                queue.offer(cur.right);
            }
        }
    }
}