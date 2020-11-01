

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageStudent {

    Student student = new Student();
    ArrayList<Student> arrayList = new ArrayList();


    //增
    public ArrayList add() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入名字");
        String name = scanner.next();
        System.out.println("输入学号");
        String number = scanner.next();
        System.out.println("输入班级");
        String classban = scanner.next();
        System.out.println("输入家长电话");
        long patriarchPhone = scanner.nextLong();
        student = new Student(name, number, classban, patriarchPhone);
        arrayList.add(student);
        Io.controlIO(arrayList);
        return arrayList;
    }

    //删
    public void remove(String number) {


        for (Student m : arrayList
        ) {
            if (m.getNumber() == number) {
                arrayList.remove(m);
                break;
            } else {
                System.out.println("没有学生");
            }
        }
    }

    //查
    public boolean find(String number) {

        for (Student m : arrayList
        ) {
            if (m.getNumber() == number) {
                System.out.println("查到了");
                return true;
            } else {
                System.out.println("没有学生");
            }
        }
        return false;
    }

    public void change(String number) {
        for (Student m : arrayList
        ) {
            if (m.getNumber() == number) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入1改名字,2改班级,3改家长电话");
                int a = scanner.nextInt();
                switch (a) {
                    case 1:
                        System.out.println("输入新名字");
                        String name = scanner.next();
                        m.setName(name);
                        break;
                    case 2:
                        System.out.println("输入新班级");
                        String calssban = scanner.next();
                        m.setClassban(calssban);
                        break;
                    case 3:
                        System.out.println("输入新的家长电话");
                        String p = scanner.next();
                        m.setClassban(p);
                        break;
                    default:
                        System.out.println("输入有误");
                }
            } else {
                System.out.println("没有该学生");
            }
        }


    }
}
