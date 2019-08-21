/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Ex4_InputStreamReader {
    public static void main(String[] args){
        BufferedReader br = null;
        String path = "C:\\bigdataStudy\\java\\demo\\ex3_obj.txt";
        try {
            br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(path))
            );
            String str =null;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))){
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
