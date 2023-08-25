package Test01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class 银行业务_队列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] array = new Integer[n];           //获取第一个值为数组大小
        String str = new String();
        for (int i = 0; i<n;i++)
            array[i] = sc.nextInt();

        ArrayDeque DA = new ArrayDeque();           // DequeA
        ArrayDeque DB = new ArrayDeque();           // DequeB

        // 向DequeA和DequeB中存入数据
        for(int i = 0;i<array.length;i++){
            if (array[i]%2!=0) {
                DA.addLast(array[i]);
            }else {
                DB.addLast(array[i]);
            }
        }

       while(!DA.isEmpty() && !DB.isEmpty()){           // DequeA和DequeB不为空的时候
            if(DA.size()%2==0 && DA.size()>=2){         //当为偶数的时候则进入DA队列
                str += DA.removeFirst()+" ";
                str += DA.removeFirst()+" ";
                str += DB.removeFirst()+" ";
            }else{ // 如果进入else则意味着arrayDeque1.size() == 1
                str += DA.removeFirst()+" ";
                str += DB.removeFirst()+" ";
            }
        }
       if(DA.isEmpty()){
            DA = DB;
        }
        if(!DA.isEmpty()){
            while(!DA.isEmpty()){
                str += DA.removeFirst()+" ";
            }
        }
        System.out.println(str.substring(0,str.length()-1));

    }

}
