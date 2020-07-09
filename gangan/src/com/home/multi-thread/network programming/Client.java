import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 55555);
        System.out.println("这是客户端,连接上服务器了,等待回应");
        while (true) {
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String txt = br.readLine();
            System.out.println(txt);
            OutputStream os = socket.getOutputStream();
            PrintStream ps = new PrintStream(os);
            Scanner scanner = new Scanner(System.in);
            String talk = scanner.next();
            ps.println("小明的哥哥:" + talk);
        }
    }
}
