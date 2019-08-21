package Ex1;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Ex2_DataOutputStream
 * 데이터의 자료형까지 함께 저장
 * 저장된 순서대로 InputStream에 읽어 들여야 한다.
 */
public class Ex2_DataOutputStream {
    private String path;
    public Ex2_DataOutputStream(){
        path = "C:\\bigdataStudy\\java\\demo\\ex2_data.txt";
    }
    //DataType과 함께 입력을 처리하는 메서드.
    public void dataWrite(){
        //자동으로 close()를 수행한다. 버전에 주의하자.
        try(DataOutputStream dos = 
                new DataOutputStream(new FileOutputStream(path))){
            //입력 순서가 매우 중요하다.
            dos.writeInt(10);        //메소드를 통해 해당타입의 데이터를 넣는다.
            dos.writeBoolean(true);
            dos.writeChar('A');
            dos.writeFloat(10.5f);
            dos.writeUTF("MyTest");
            
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args) throws IOException {
        new Ex2_DataOutputStream().dataWrite();
        
    }
}
