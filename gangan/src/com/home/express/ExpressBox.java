
import java.util.Random;

//快递柜,假设是10X10大小
public class ExpressBox {
    Random random = new Random();
    static int boxLong = 10;
    static int boxWide = 10;
    static int itemCodelCapacity = 100;
    int[][] expressPositionIn = new int[boxLong][boxWide];
    int[][] expressPositionOut = new int[boxLong][boxWide];
    static  int[] itemCode = new int[itemCodelCapacity];
    /* static void initialize() {
 expressPosition=new int[boxLong][boxWide];
         for (int i = 0; i < boxLong; i++) {
             for (int j = 0; j < boxWide; j++) {
                 expressPosition[i][j] = 0;
             }
         }
         for (int i = 0; i < itemCodelCapacity; i++) {
             itemCode[i] = 0;
         }
     }*/
    static int[] a = new int[2];
    public Object boxadd() {
        for (int i = 0; i < boxLong; i++) {
            for (int j = 0; j < boxWide; j++) {
                int x = random.nextInt(boxLong);
                int y = random.nextInt(boxWide);
                if ( expressPositionIn[i][j]==0) {
                    expressPositionIn[i][j] = 1;
                    a[0] = x;
                    a[1] = y;
                    expressPositionOut[x][y]=1;
                    return a;
                }
            }
        }
        return "柜子满了";
    }
    public int getItemCode() throws ClassCastException {
        int x = random.nextInt(900000) + 100000;
        return x;

    }
    public   Object getExpressPosition() {
        return a;
    }
}

