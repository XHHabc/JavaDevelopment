package Test02;

public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.createTree();
        System.out.print("前序遍历:");
        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        System.out.print("中序遍历:");
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        System.out.print("后序遍历:");
        binaryTree.posOrder(binaryTree.root);
        System.out.println();
        System.out.print("二叉树层序遍历：");
        binaryTree.levelOrder(binaryTree.root);

    }
}
