import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 55555);
        System.out.println("这是客户端,连接上服务器了");





    }


















    /*第一次连上
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 55555);
        System.out.println("这是客户端,连接上服务器了");
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String txt = br.readLine();
        System.out.println("收到: " + txt);

        OutputStream os=socket.getOutputStream();
        PrintStream ps=new PrintStream(os);
        Scanner scanner=new Scanner(System.in);
        String talk=scanner.next();
        ps.println("你连上了客户端,我要告诉你"+talk);

    }*/
}
