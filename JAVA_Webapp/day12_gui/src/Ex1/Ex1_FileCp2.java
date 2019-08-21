package Ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ex1_FileCp2 { 
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        String path1 =  "C:\\bigdataStudy\\java\\demo\\jdk.exe";
        String path2 =  "C:\\bigdataStudy\\java\\demo\\myjdk.exe";
        
//        FileInputStream fis = null;             //���⼭�� �����ϸ� ������ �̰͵� �ݾ��־�� �ϱ⶧���� �ּ�ó��.
//        FileOutputStream fos = null;
        //2�� ��Ʈ���� ����.   FileInputStream�� ������� �� ���� �ӵ��� �ξ� �����ٴ°��� Ȯ�� �� �� �ִ�.
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1�� ��Ʈ���� �ּҸ� ���ڷ� ����!
            bis = new BufferedInputStream(new FileInputStream(path1));
            bos = new BufferedOutputStream(new FileOutputStream(path2));
            int readV = 0;
            //bis �κ��� ���ۿ� ��� �о� ���̸鼭
            //bos �� �о�� ��η� ���۴����� �����Ѵ�.
            while((readV = bis.read()) != -1){
                bos.write(readV);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1_FileCp2.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IOException ex) {
            if(bis != null) bis.close();
            if(bos != null) bos.close();
        }
        long end  = System.currentTimeMillis();
        System.out.println("������ �ð� : " + (end - start));
    }
}
