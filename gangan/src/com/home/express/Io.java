import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;

public class Io {
    static PrintStream Io() throws IOException {
        Socket socket = new Socket("127.0.0.1", 55565);
        OutputStream f = socket.getOutputStream();
        PrintStream oos=new PrintStream(f);
        return oos;
    }
    public static void controlIO(ArrayList arrayList) throws IOException, ClassNotFoundException {
        PrintStream oos = Io.Io();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        oos.println(arrayList + simpleDateFormat.format(new Date()));
    }
}
