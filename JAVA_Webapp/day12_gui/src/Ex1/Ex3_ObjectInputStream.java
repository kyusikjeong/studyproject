/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Ex3_ObjectInputStream {
 
    public void print() throws IOException{
       String path = "C:\\bigdataStudy\\java\\demo\\ex3_obj.txt";
       try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
           //직렬화 대상이 되는 객체. *Serializable 인터페이스 구현
           Ex3_Member v = (Ex3_Member)ois.readObject();
           System.out.println(v.getId());
           System.out.println(v.getName());
           System.out.println(v.getPwd());
           System.out.println(v.getAge());
           System.out.println(v.getPay());
           
          //직렬화
          // ois.readObject();
       } catch(Exception e){
           e.printStackTrace();
        } 
       }
    public static void main(String[] args) throws IOException {
        new Ex3_ObjectInputStream().print();
    }
}
     

