import java.io.IOException;
import java.util.Scanner;

public class UI {


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student();
        Io io = new Io();
        ManageStudent manageStudent = new ManageStudent();

        System.out.println("欢迎使用学生管理系统");
        while (true) {

            System.out.println("输入1.增加学生2.删除学生3.查找学生4.修改学生 0.退出");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            if (a == 0) {
                break;
            }
            switch (a) {

                case 1:
                    manageStudent.add();
                    break;
                case 2:
                    System.out.println("输入要删除同学学号");
                    String no = scanner.next();
                    manageStudent.remove(no);
                    break;
                case 3:
                    System.out.println("输入要查找同学学号");
                    String no2 = scanner.next();
                    manageStudent.find(no2);
                    break;
                case 4:
                    System.out.println("输入要修改同学学号");
                    String no3 = scanner.next();
                    manageStudent.change(no3);
                    break;

                default:
                    System.out.println("输入有误");
            }

        }
    }
}

