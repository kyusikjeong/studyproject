
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
                    new FileOutputStream(path),true);//�ι�° ����: autoFlush(�ڵ����� ������ ����ش�)
                    // new FileWriter (path); �� ��� �־ �����ϴ�. ������ ����� �����ϹǷ�...
            pw.println("hi, �ݰ����ϴ�!");
        //pw.flush();
        } catch (Exception ex) {
        } finally {
            pw.close();
        }
    }
}
