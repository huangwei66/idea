import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Scanner;

public class
SaveWang {
    public static void main(String[] args) throws Exception {
        //http://wx.zemuo.com/paper/news/hdsl/index.php?txt1=新闻


        Scanner scanner = new Scanner(System.in);
        System.out.println("ps没我方便的说,你想p什么字");
        String title = scanner.nextLine();
        title = URLEncoder.encode(title, "UTF-8");
        URL url = new URL("http://wx.zemuo.com/paper/news/hdsl/img.php?txt1=" + title);
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        File file = new File("C:\\Users\\17243\\Desktop\\" + System.currentTimeMillis() + ".png");
        FileOutputStream fos = new FileOutputStream(file);
        int len = -1;
        byte[] bytes = new byte[
                1024 * 1024];
        while (true) {
            len = is.read(bytes);
            if (len == -1) {
                break;

            }
            fos.write(bytes, 0, len);
        }
        System.out.println("p好了,你还想p什么字,重新运行");
    }
}
