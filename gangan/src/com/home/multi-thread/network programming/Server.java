import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {

       ServerSocket server=new ServerSocket(55555);
        System.out.println("服务器程序启动");

        while (true) {
            Socket socket = server.accept();
            System.out.println("对方连上了");
        }

    }



/*第一次连上

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(55555);
        System.out.println("服务器程序启动");
        Socket socket = server.accept();
        System.out.println("对方连上了,想说什么");
        OutputStream os=socket.getOutputStream();
        PrintStream ps=new PrintStream(os);
        Scanner scanner=new Scanner(System.in);
        String talk=scanner.next();
        ps.println("我要告诉你: "+talk);
        InputStream is = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        System.out.println("我回复说:");
        String txt = br.readLine();
        System.out.println("收到: " + txt);

        System.out.println("服务器程序关闭");

    }
*/


}
