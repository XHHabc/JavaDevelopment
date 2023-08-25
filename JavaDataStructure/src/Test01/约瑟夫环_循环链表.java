package Test01;

import java.util.Scanner;

public class 约瑟夫环_循环链表 {
    public static void main(String[] args) {
        //解决约瑟夫问题
        //获取三个整数值
        Scanner sc=new Scanner(System.in);
        int n=0;
        int distance=0;
        int k=0;
        for (int i = 0; i < 1; ) {
            System.out.println("请输入三个整数");
            n= sc.nextInt();        //n个人
            distance= sc.nextInt(); //数到第distance个
            k= sc.nextInt();        //剩下k个人
            if (n>26||n<=0||distance>26||distance<=0||k>26||k<=0){
                System.out.println("输入整数均大于0且不可超过26位，请重新输入");
                continue;
            }
            i++;
        }
        //构建循环链表，包含n个结点，分别储存1-n之间的值
        Node<Integer> first=null;   //首结点
        Node<Integer> pre=null; //记录前一个结点
        for(int i=1;i<=n;i++){
            //如果是第一个结点
            if(i==1){
                first=new Node<>(i,null);
                pre=first;
                continue;}
            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i, null);
            pre.next=newNode;
            pre=newNode;
            //如果是最后一个结点，则将其下一个结点指向first,变为循环链表
            if(i==n){pre.next=first;}
        }

        printDis(first,n,distance,k);

    }

    //结点类
    public static class Node<T>{
        private T data;
        private Node next;
        public Node(T data,Node next){
            this.data=data;
            this.next=next;
        }
    }
    //遍历的方法
    public static void printDis(Node<Integer> first,int nCount,int distance,int k){
        //需要count计数器，模拟报数
        int count=0;
        //记录进行了几次删除操作，可因此推导出表剩余结点个数
        int countNode=0;
        //遍历循环链表
        Node<Integer> n=first;
        Node<Integer> pre2=null;
        while(n!=n.next){
            //模拟报数
            count++;
            if(count==distance){
                //删除当前节点
                pre2.next=n.next;
                char a=(char)(n.data+64);//将输出的整数值变为字符abc
                System.out.print(a+",");
                count=0;
                n=n.next;
                countNode++;
            }else{
                pre2=n;
                n=n.next;
            }
            //遍历剩余的个数
            if ((nCount-countNode)==k){
                break;
            }
        }
        //最后一个结点数据
        //System.out.println(n.data);
    }

}