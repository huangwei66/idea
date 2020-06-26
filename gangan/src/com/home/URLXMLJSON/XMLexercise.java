import com.thoughtworks.xstream.XStream;
import org.dom4j.*;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Objects;

public class XMLexercise {

    public static void main(String[] args) {
        Person p = new Person();
        p.setName("张三");
        p.setAge(18);

        //XStream使用
        //1、创建XStream对象
        XStream x = new XStream();
        //2、修改某个类型生成的节点 （可选的，默认为包名.类名）
        x.alias("person",Person.class);
        //3、传入对象，开始生成
        String xml = x.toXML(p);
        System.out.println(xml);
    }


    static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person() {
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Person person = (Person) o;
            return age == person.age &&
                    Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }
    }
  /*  public static void main(String[] args) throws IOException {
        //1.    通过文档帮助器，创建一个文档对象
        Document doc = DocumentHelper.createDocument();
        //2.    给文档添加第一个节点（根节点）
        Element books = doc.addElement("books");
        //3.    通过根节点， 丰富子节点
        for(int i=0;i<100;i++){
            Element book = books.addElement("book");
            Element name = book.addElement("name");
            name.setText(i+"种苹果的小姑娘~");
            Element info = book.addElement("info");
            info.setText(i+"辛勤种植苹果的故事~");
            book.addAttribute("id",100+i+"");
        }
        //4.    创建一个文件输出流
        FileOutputStream fos = new FileOutputStream("books.xml");
        //5.    将输出流转换为XML输出流
        XMLWriter xw = new XMLWriter(fos);
        //6.    写出文档
        xw.write(doc);
        //7.    释放资源
        xw.close();
        System.out.println("执行完毕");
    }
*/
   /* public static void main(String[] args) throws IOException, DocumentException {
        String phone = "18313935565";
        //1.    获取到XML资源的输入流
        URL url = new URL("http://apis.juhe.cn/mobile/get?phone="+phone+"&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        //2.    创建一个XML读取对象
        SAXReader sr = new SAXReader();
        //3.    通过读取对象 读取XML数据，并返回文档对象
        Document doc = sr.read(is);

        Node node = doc.selectSingleNode("//company");
        System.out.println("运营商："+node.getText());
        is.close();

    }*/



/*

    public static class Demo3 {
        public static void main(String[] args) throws IOException, DocumentException {
            //1.    获取输入流
            FileInputStream fis = new FileInputStream("src/com/home/Demo1.xml");
            //2.    创建XML读取对象
            SAXReader sr = new SAXReader();
            //3.    读取并得到文档对象
            Document doc = sr.read(fis);
            //4.    通过文档对象+xpath，查找所有的name节点
        */
/*List<Node> names = doc.selectNodes("//book[@id='1001']//name");
        for (int i=0;i<names.size();i++){
            System.out.println(names.get(i).getName());
            System.out.println(names.get(i).getText());
        }*//*

            Node n = doc.selectSingleNode("//book[@id='1002']//name");
            System.out.println(n.getName() + ":" + n.getText());

            fis.close();
        }
    }
*/

    /*public static void main(String[] args) throws IOException, DocumentException {
        String phone = "17674176761";
        //1.    获取到XML资源的输入流
        URL url = new URL("http://apis.juhe.cn/mobile/get?phone="+phone+"&dtype=xml&key=9f3923e8f87f1ea50ed4ec8c39cc9253");
        URLConnection conn = url.openConnection();
        InputStream is = conn.getInputStream();
        //2.    创建一个XML读取对象
        SAXReader sr = new SAXReader();
        //3.    通过读取对象 读取XML数据，并返回文档对象
        Document doc = sr.read(is);
        //4.    获取根节点
        Element root = doc.getRootElement();
        //5.    解析内容
        String code = root.elementText("resultcode");
        if("200".equals(code)){
            Element result = root.element("result");
            String province = result.elementText("province");
            String city = result.elementText("city");
            if(province.equals(city)){
                System.out.println("手机号码归属地为："+city);
            }else{
                System.out.println("手机号码归属地为："+province+" "+city);
            }
        }else{
            System.out.println("请输入正确的手机号码");
        }
    }
*/





   /* public static void main(String[] args) throws IOException, DocumentException {
        //1.    获取输入流
        FileInputStream fis = new FileInputStream("c://Demo1.xml");
        //2.    创建XML读取对象
        SAXReader sr = new SAXReader();
        //3.    读取并得到文档对象
        Document doc = sr.read(fis);
        //4.    通过文档获取根元素
        Element root = doc.getRootElement();
        //5.    开始解析元素
        System.out.println(root.getName());

        //操作一波
        //Element book = root.element("book");
        //Element name = book.element("name");
        //System.out.println(name.getText());
        List<Element> es = root.elements();
        for(int i=0;i<es.size();i++){
            Element book = es.get(i);
            System.out.println(book.attributeValue("id"));
            System.out.println(book.elementText("name"));
            System.out.println(book.elementText("info"));
            System.out.println("-----------------------------");
        }

        fis.close();
    }
*/
}
