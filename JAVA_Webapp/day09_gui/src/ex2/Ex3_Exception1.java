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
        //�ڵ����� close ���ִ� ���.
        //jdk7���� ���� �������ش�.
        //�ش� Ŭ������ Closeable�������̽��� ������ Ŭ�������� �ش�!
        
        try(FileInputStream fi = new FileInputStream(path):){
            prop.load(fi);
        }catch (FileNotFoundException e) {
                
        }catch(IOException){
                
        }
    }
}
