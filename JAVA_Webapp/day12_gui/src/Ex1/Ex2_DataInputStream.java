/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Ex2_DataInputStream {
    private String path;
    public Ex2_DataInputStream(){
        path = "C:\\bigdataStudy\\java\\demo\\ex2_data.txt";
    }
    
    public void printDataStream() throws IOException{
        
        try(DataInputStream dos = 
                new DataInputStream(new FileInputStream(path))){
            //입력 순서대로 꺼내야 함.
            
            System.out.println(dos.readInt());
            System.out.println(dos.readBoolean());
            System.out.println(dos.readChar());
            System.out.println(dos.readFloat());
            System.out.println(dos.readUTF());
        
        } catch(Exception e){
            e.printStackTrace();
        }
      
  
    }
    public static void main(String[] args) throws IOException {
        new Ex2_DataInputStream().printDataStream();
    }
}
