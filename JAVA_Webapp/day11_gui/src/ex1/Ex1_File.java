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
public class Ex1_File {
    public static void main(String[] args) {//mkdir -p 
        String path = "C:\\bigdataStudy\\java\\demo\\demo.txt";   //파일의 경로입력
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
        System.out.println("부모 디렉토리를 리턴?"+f.getParent());
        
        
        
        File f2 = new File("C:\\bigdataStudy\\java\\demo\\asdf.txt");
         if(!f2.exists()){   // 논리부정 연산자 !를 사용했으므로 해당경로에 파일이 없다면 true가 됨. 
             
            try{                    //try catch는 개발자가 파일 실행시 발생할 수 있는 에러에 대비해서 
                                    //준비해둔 코드를 실행시키는 것이라고 생각하면 좋다.
                                    //try 안에 구문을 먼저 실행하고 여기서 예외(에러)가 발생시
                                    //catch(매개변수) 매개변수 위치에 에러에 해당하는 exception 을 선언해두면 
                                    //catch 블럭으로 이동해서 해당 구문을 실행하고 종료된다.
                                    
                 System.out.println("존재 asdf 를 만들겠습니다");   //파일이 없으면 블럭 안으로 들어와서 구문을 실행.
                 //0byte 짜리 파일을 만들어 준다. unix 에서 touch명령어
                 f2.createNewFile();//새로운 파일을 만든다.
            } catch(IOException ex){       
                ex.printStackTrace();
            }
         }else {
             System.out.println("이미 존재합니다."); //있으면 여기로.
         }
            
       //f3이란 파일 객체로
       //해당 폴더를 한번에 만들고 싶다면...
       //mkdirs - 추상적인 하위 디렉토리 까지 생성
        File f3 = new File("C:\\bigdataStudy\\java\\demo\\works\\work1");
                                //위의 경로에 폴더가 없더라도
        if(!f3.exists()){       //바로위의 조건처럼 폴더가 없으면 true. if조건 진입  
             f3.mkdirs();      //해당 메소드를 사용시 경로에 폴더가 없어도 하위 디렉토리 까지 생성

        } else {
                System.out.println("이미 존재 합니다"+f3.getAbsolutePath()); //폴더가 이미 있으면 여기로 와서 폴더의 절대경로를 출력.
        }
     }
}

