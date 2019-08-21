package Ex1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author KOSTA
 */
public class Ex3_ObjectStream  implements Serializable{
    public static void main(String[] args){
       String path = "C:\\bigdataStudy\\java\\demo\\ex3_obj.txt";
       try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))){
           
           //직렬화 대상이 되는 객체. *Serializable 인터페이스 구현
           Ex3_Member v = new Ex3_Member();
           v.setId("xman");
           v.setPwd("1");
           v.setAge(30);
           v.setName("김길동");
           v.setPay(2000);
           //직렬화
           oos.writeObject(v);
       } catch(Exception e){
           e.printStackTrace();
    }
    
}
}
