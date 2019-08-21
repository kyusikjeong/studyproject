package ex1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_FileInputStreamDemo {
    public static void main(String[] args) {
        String path = "C:\\00_GUISpace\\temptemaap.txt";
        //지역 변수로 선언 후 초기화
        //1차 스트림, 바이트 스트림
        //try 문 scope 영역 위에서 선언하는 이유를 생각해보자.
        
        FileInputStream fis = null; //이 클래스는 파일로부터 바이트 단위로 읽어들일때 사용하는 바이트 기반 입력 스트림이다.
                                    //그림, 오디오, 비디오, 텍스트 파일 등 모든 종류의 파일을 읽을 수 있다.
                                    //page 1021 참조
        try {
            //일반적인 예외(컴파일예외)
            fis = new FileInputStream(path);   //위에서 String 변수에 넣은 경로를 가진 객체 생성.
            int rdv = 0;
            //파일의 시작점에서부터 EOF(파일의 끝)까지 읽어들이는 
            //반복문, read():1byte 씩 읽어오는 메서드. 끝 -1 을 반환
            int test = fis.read();
            System.out.println(test);
            while((rdv = fis.read()) != -1){   //해당 조건이 false가 될때까지 반복. 풀어보면
                                               //fis.read() 는 해당 스트림의 바이트를 리턴한다. 1바이트씩 읽어오면서 파일의 끝까지 읽으면 -1을 리턴한다.
                                               //그러므로 괄호안의 rdv = fis.read()는 일단 위에서 생성한 int형 변수에 위에서 생성한 객체 안의 파일의 바이트를 1바이트씩 읽어들여 저장하고 
                                               //파일을 다 읽지 않았으면 != -1 조건이 충족이 안되어 true 니까 계속 돌다가
                                               //끝까지 다 읽고 -1을 리턴 받으면 != -1 조건을 만족하여 false가 되면서 종료된다.
               System.out.print((char)rdv);   //파일 내부의 내용을 문자로 출력하기 위해 char형으로 형변환 하여 출력. 
            }
            //파일이 없으면 발생되는 예외
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1_FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("파일이 존재하지 않을경우");
        } catch (IOException ex) { 
            Logger.getLogger(Ex1_FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("읽어들이는 오류");
        } finally { //finally 구문은 위의 try catch 구문에서 exception이 발생하든 말든 마지막에 실행되는 구문이다.
            try {
                if(fis !=null){
                     fis.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(Ex1_FileInputStreamDemo.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
        }
        
        
    }
}
