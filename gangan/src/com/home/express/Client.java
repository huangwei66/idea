import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException, ClassNotFoundException {


        System.out.println("这是客户端,连接上服务器了");
        ExpressManage expressManage = new ExpressManage();
        while (true) {
            System.out.println("请根据提示,输入功能序号");
            System.out.println("1.快递录入");
            System.out.println("2.快递取出");
            System.out.println("3.查看所有");
            System.out.println("0.退出程序");
            Scanner scanner = new Scanner(System.in);
            int a = scanner.nextInt();
            if (a == 0) {
                break;
            }
            switch (a) {
                case 1:
                    expressManage.add();
                    break;
                case 2:
                    expressManage.takeAway();
                    break;
                case 3:
                    expressManage.find();
                    break;
                default:
                    System.out.println("输入有误");
            }
        }
    }
}
