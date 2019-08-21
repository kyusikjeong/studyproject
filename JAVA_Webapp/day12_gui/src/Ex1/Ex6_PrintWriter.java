
package Ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ex6_PrintWriter {
    public static void main(String[] args) {
        PrintWriter pw = null;
        String path = "C:\\bigdataStudy\\java\\demo\\memo3.txt";
        
       
        try {
            pw = new PrintWriter(
                    new FileOutputStream(path),true);//두번째 인자: autoFlush(자동으로 버프를 비워준다)
                    // new FileWriter (path); 를 대신 넣어도 가능하다. 동일한 기능을 수행하므로...
            pw.println("hi, 반갑습니다!");
        //pw.flush();
        } catch (Exception ex) {
        } finally {
            pw.close();
        }
    }
}
