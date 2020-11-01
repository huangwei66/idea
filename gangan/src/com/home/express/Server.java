import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {

    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket server = new ServerSocket(55565);
            System.out.println("服务器程序启动");
            Socket socket = server.accept();
            System.out.println("客户端上线");
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String txt = br.readLine();
            System.out.println("收到: " + txt);
          /*  File file = new File("express.txt");
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file, true));
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = is.read(bytes)) != -1) {
                bos.write(bytes, 0, len);
            }*/
            System.out.println("服务器程序关闭");
        }
    }
}
