import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExpressManage {
    ExpressBox expressBox = new ExpressBox();
    Express express = new Express();
    ArrayList<Express> arrayList = new ArrayList();

    //增
    public ArrayList add() throws IOException, ClassNotFoundException, ClassCastException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入快递公司");
        String company = scanner.next();
        System.out.println("输入快递单号");
        String number = scanner.next();
        System.out.println("输入收件人手机号码");
        String phonenumber = scanner.next();
        express = new Express(company, number, phonenumber);
        arrayList.add(express);
        int a = expressBox.getItemCode();
        System.out.println("快递录入成功,取件码: " + a);
        express.setItemCode(a);


        Io.controlIO(arrayList);
        return arrayList;
    }

    //删
    public void remove(String number) {
        for (Express m : arrayList
        ) {
            if (m.getNumber().equals(number)) {
                arrayList.remove(m);
                break;
            } else {
                System.out.println("没有学生");
            }
        }
    }

    //查
    public boolean find() {

        System.out.println("输入单号");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for (Express m : arrayList
        ) {
            if (m.getNumber().equals(s)) {
                System.out.println("查到了");
                express.toString();
                return true;
            }
        }
        System.out.println("没有这个快递");
        return false;
    }

    public void change(int number) {
        for (Express m : arrayList
        ) {
            if (m.getNumber().equals(number)) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("输入1改公司,2改单号,3改收件人电话");
                int a = scanner.nextInt();
                switch (a) {
                    case 1:
                        System.out.println("输入新名字");
                        String name = scanner.next();
                        m.setCompany(name);
                        break;
                    case 2:
                        System.out.println("输入新班级");
                        String calssban = scanner.next();
                        m.setNumber(calssban);
                        break;
                    case 3:
                        System.out.println("输入新的家长电话");
                        String p = scanner.next();
                        m.setPhoneNumber(p);
                        break;
                    default:
                        System.out.println("输入有误");
                }
            } else {
                System.out.println("没有该快递");
            }
        }
    }

    void takeAway() {
        System.out.println("输入取件码");
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        for (Express m : arrayList
        ) {
            if (m.getItemCode() == a) {
                arrayList.remove(m);
                System.out.println("快递拿走了");
                break;
            } else {
                System.out.println("取件码错误");
            }
        }
    }
}
