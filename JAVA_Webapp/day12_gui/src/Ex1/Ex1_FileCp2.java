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
        
//        FileInputStream fis = null;             //여기서도 선언하면 닫을때 이것도 닫아주어야 하기때문에 주석처리.
//        FileOutputStream fos = null;
        //2차 스트림을 선언.   FileInputStream만 사용했을 시 보다 속도가 훨씬 빠르다는것을 확인 할 수 있다.
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1차 스트림의 주소를 인자로 전달!
            bis = new BufferedInputStream(new FileInputStream(path1));
            bos = new BufferedOutputStream(new FileOutputStream(path2));
            int readV = 0;
            //bis 로부터 버퍼에 담아 읽어 들이면서
            //bos 로 읽어온 경로로 버퍼단위로 저장한다.
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
        System.out.println("복사한 시간 : " + (end - start));
    }
}
