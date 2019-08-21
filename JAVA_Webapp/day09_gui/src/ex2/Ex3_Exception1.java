package ex2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author KOSTA
 */
public class Ex3_Exception1 {
    public Ex3_Exception1(){
        Properties prop = new Properties();
        String path="";
        //자동으로 close 해주는 기능.
        //jdk7버전 부터 지원해준다.
        //해당 클래스가 Closeable인터페이스를 구현한 클래스들이 해당!
        
        try(FileInputStream fi = new FileInputStream(path):){
            prop.load(fi);
        }catch (FileNotFoundException e) {
                
        }catch(IOException){
                
        }
    }
}
