/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author KOSTA
 */
public class Ex1_File1 {
    public static void main(String[] args) {//mkdir -p 
        String path = "demo.txt";   //파일의 경로입력
        //파일 객체를 생성 : 해당 파일이나 경로가 없어도 추상적인 경로 가능
        File f = new File(path); //파일 생성자에 파일의 경로를 던진다는 것은 그걸 받아주는 생성자가 있다는 것.
        //위의 생성자는 문자열 path를 가지고 경로를 생성하여 File객체를 생성한다.
        
        System.out.println("test 가 존재하는가"+f.exists());
        
        if(f.exists()){   //exists() 메소드는 디렉토리 또는 파일이 해당경로에 존재한다면 true 를 리턴하고 아니면 false를 리턴
            System.out.println("ㅇㅇ 존재");
            
        }
        System.out.println("test.txt가 파일인가?"+f.isFile());     //page 1020 api참조. 
        System.out.println("실행이 가능한가?"+f.canExecute());
        System.out.println("작성이 가능한가?"+f.canWrite());
        System.out.println("절대경로"+f.getAbsolutePath());
        System.out.println("디렉토리인가? "+f.isDirectory());
        System.out.println("읽을 수 있는 파일인가?"+f.canRead());
        System.out.println("파일의 이름을 리턴"+f.getName());
        System.out.println("부모 디렉토리를 리턴?"+f.getPath());
        
        
        
      
}

