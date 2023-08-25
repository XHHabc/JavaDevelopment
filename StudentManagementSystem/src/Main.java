import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       /* 案例需求
        针对目前我们的所学内容，完成一个综合案例：学生管理系统。该系统主要功能如下：
        添加学生：通过键盘录入学生信息，添加到集合中
        删除学生：通过键盘录入要删除学生的学号，将该学生对象从集合中删除
        修改学生：通过键盘录入要修改学生的学号，将该学生对象其他信息进行修改
        查看学生：将集合中的学生对象信息进行展示
        退出系统：结束程序*/
        ArrayList<Student> list = new ArrayList<>();
        loop:
        while (true) {
            System.out.println("------------学生管理系统-----------");
            System.out.println("1：添加学生信息");
            System.out.println("2：删除学生信息");
            System.out.println("3：修改学生信息");
            System.out.println("4：查询学生信息");
            System.out.println("5：退出查询");
            System.out.println("请输入选择操作编号");
            Scanner sc = new Scanner(System.in);
            String choose = sc.next();
            switch (choose) {
                case "1":
                    addStudent(list);
                    break;
                case "2":
                    deleteStudent(list);
                    break;
                case "3":
                    upDataStudent(list);
                    break;
                case "4":
                    queryStudent(list);
                    break;
                case "5":
                    System.out.println("退出");
                    break loop;
                //System.exit(0);  //退出虚拟机
                default:
                    System.out.println("异常编号");
            }
        }

    }

    //添加学生
    public static void addStudent(ArrayList<Student> list) {
        System.out.println("添加学生");
        Student s = new Student();
        Scanner sc=new Scanner(System.in);

        String id=null;
        while (true) {
            System.out.println("输入学生id");
            id = sc.next();
            if (containsId(list,id)){
                System.out.println("id已存在，重新输入");
            }else{
                s.setId(id);
                break;
            }
        }


        System.out.println("输入学生姓名");
        String name = sc.next();
        s.setName(name);

        System.out.println("输入学生年龄");
        int age = sc.nextInt();
        s.setAge(age);

        System.out.println("输入学生住址");
        String address = sc.next();
        s.setAddress(address);

        list.add(s);

        System.out.println("添加成功");
    }

    //删除学生
    public static void deleteStudent(ArrayList<Student> list) {
        System.out.println("删除学生");
        Scanner sc=new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        if (index>=0){
            list.remove(index);
            System.out.println("删除成功，id为："+id);
        }else {
            System.out.println("删除失败，id查不到");
        }


    }

    //修改学生
    public static void upDataStudent(ArrayList<Student> list) {
        System.out.println("修改学生");
        Scanner sc=new Scanner(System.in);
        String id = sc.next();
        int index = getIndex(list, id);
        if (index==-1){
            System.out.println("修改的id不存在");
            return;
        }
        Student stu = list.get(index);
        System.out.println("输入修改的学生id");
        String newId = sc.next();
        stu.setId(newId);

        System.out.println("输入修改的学生姓名");
        String newName = sc.next();
        stu.setName(newName);

        System.out.println("输入修改的学生年龄");
        int newAge = sc.nextInt();
        stu.setAge(newAge);

        System.out.println("输入修改的学生住址");
        String newAddress = sc.next();
        stu.setAddress(newAddress);

        System.out.println("修改成功");
    }

    //查询学生
    public static void queryStudent(ArrayList<Student> list) {
        System.out.println("查询学生");
        if (list.size() == 0) {
            System.out.println("当前信息为空");
            return;
        }
        System.out.println("id\t姓名\t年龄\t住址");
        for (int i = 0; i < list.size(); i++) {
            Student stu = list.get(i);
            System.out.println(stu.getId() + "\t" + stu.getName() + "\t" + stu.getAge() + "\t" + stu.getAddress());
        }

    }

    //检查id唯一性
    public static boolean containsId(ArrayList<Student> list,String id){
        /*for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                return true;
            }
        }
        return false;*/
        return getIndex(list,id)>=0;
    }
    //利用id查找索引
    public static int getIndex(ArrayList<Student> list,String id){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)){
                return i;
            }
        }
        return -1;
    }

}