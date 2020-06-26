import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Io {

    static public void controlIO(ArrayList arrayList) throws IOException, ClassNotFoundException {
        FileOutputStream f = new FileOutputStream("d:\\学生管理系统信息.txt", true);
        ObjectOutputStream oos = new ObjectOutputStream(f);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        oos.writeObject(arrayList + simpleDateFormat.format(new Date()));
        oos.flush();
        oos.close();
    }
/*    //输出内容
    static void controlIO1(ArrayList arrayList) throws IOException, ClassNotFoundException {
        ObjectIutputStream oos = new ObjectIutputStream(new FileIutputStream("d:\\huangwei.txt",true));
        oos.writeObject(arrayList);
        oos.close();
    }
*/
}
