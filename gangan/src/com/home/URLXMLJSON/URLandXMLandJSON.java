import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLandXMLandJSON {
    /**JSON
     * JSON: JavaScript Object Notation JS对象简谱 , 是一种轻量级的数据交换格式
     *优点: 程序员解析比xml简单,计算机解析比xml快,数据传输时占的空间更小,网速就能提高
     * 更多详情看课件.pdf
     */





    /**XML
     简介
     可扩展标记语言（eXtensible Markup Language）
     特性:
     1. xml具有平台无关性, 是一门独立的标记语言.
     2. xml具有自我描述性
     为什么学习XML？
     1. 网络数据传输.
     2. 数据存储
     3. 配置文件
     XML文件
     .XML文件是保存XML数据的一种方式
     XML数据也可以以其他的方式存在（如在内存中构建XML数据）。
     不要将XML语言狭隘的理解成XML文件。
     *更多详情看课件.pdf
     */



    /**
     * API例子2
     * 智能聊天API;
     * 协议类型:https
     * 网址(资源路径):api.jisuapi.com/iqa/query
     * 参数列表:
     * question:发送的消息内容
     * appkey:扣费密钥:5701500bf5e5e1df
     */

  /*  public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("欢迎使用智能聊天机器人");
        while (true) {
            System.out.println("说点啥");
            String msg = input.nextLine();
            URL url = new URL("https://api.jisuapi.com/iqa/query?appkey=c77306044c3e06f6&question=杭州天气");
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            System.out.println(br.readLine());
            br.close();
        }
    }*/


    /**
     * API使用
     * URL请求服务器如何传参数
     * GET请求方式传递参数的格式:  协议://资源路径+名称?name=value1&name2=value2
     * 例子:  急速数据短信发送API
     * 协议类型:https
     * 网址(资源路径):api.jisuapi.com/sms/send
     * 参数列表:
     * mobile:手机号
     * content:内容,需要模板过审 例子:欢迎注册,您的验证码为?[abc123]
     * appkey:扣费密钥5701500bf5e5e1df
     */

   /* public static void main(String[] args) throws Exception {
        URL url = new URL("https://api.jisuapi.com/sms/send?mobile=17674176761&content=欢迎注册,您的验证码为?[ITDAGE]&appkey=5701500bf5e5e1df");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        System.out.println(br.readLine());
    }*/

    /**URL乱码解决
     URLEncode
     将普通字符串转换成 application/x-www-from-urlencoded 字符串
     示例：
     //字符串中的非西欧字符的内容，会被转化成%XX%XX XX 为十六进制的数字
     String urlString = URLEncoder.encode("你好", "UTF-8");
     System.out.println(urlString);//输出：%E4%BD%A0%E5%A5%BD
     URLDecode
     将 application/x-www-from-urlencoded 字符串转换成普通字符串
     示例：
     String keyWord = URLDecoder.decode("%E4%BD%A0%E5%A5%BD", "UTF-8");
     System.out.println(keyWord);//输出：你好
     */


/**URL定义及使用
 * ### URL
 *  定义:统一资源定位符（Uniform Resource Locator）,它表示 Internet 上某一资源的地址
 * 语法格式:protocol://resourceName
 * #### URL 类
 * 常用的创建 URL 的方式： （使用基本地址和相对 URL 构造一个 URL 对象。）
 * URL url = new URL(“地址”);
 * 常用的 URL 中方法：
 * public String getFile() ： 获取该 URL 的路径+文件名;
 * public URLConnection openConnection() ： 获取通信连接对象
 *
 */
  /*  文件下载初体验
        public static void main(String[] args) throws Exception {
        //1.创建URL变量,URl当然也可以输入
        URL url = new URL("https://dldir1.qq.com/weixin/Windows/WeChatSetup.exe");
        //获取文件名称
        String name = url.getFile();
        name = name.substring(name.lastIndexOf("/") + 1);
        //由url打开链接
        URLConnection connection = url.openConnection();
        //由链接获取文件大小,字节长度
        long length = connection.getContentLength();
        //建立文件由服务器到电脑客户端的流
        InputStream is = connection.getInputStream();
        //建立电脑客户端到指定文件位置的保存流
        File file = new File("C:\\Users\\17243\\Desktop\\" + name);
        FileOutputStream fos = new FileOutputStream(file);
        int len = -1;
        int sum = 0;
        byte[] bytes = new byte[1024 * 1024];
        while (true) {
            len = is.read(bytes);
            if (len == -1) {
                break;
            }
            fos.write(bytes, 0, len);
            sum = sum + len;
            System.out.println("正在下载" + sum / (length / 100) + "%");
        }
        is.close();
        fos.close();
        System.out.println("下载完毕");
    }*/
}