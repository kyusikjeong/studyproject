package ex1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_FileOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        //파일이 존재하지 않으면 
        String path = "C:\\bigdataStudy\\java\\asdfasdf.txt";
        FileOutputStream fos = null;
        
        try {
            //파일이 없을시 파일을 생성한다.
            //두번째 인자에 데이터를 append
            fos = new FileOutputStream(path,true);     //파일 경로 뒤에 true를 추가하면 기존의 파일 내용 끝에 데이터를 추가하게 된다.
            fos.write(66); 
            fos.write(65);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ex1_FileOutputStreamDemo.class.getName()).log(Level.SEVERE, null, ex); 
         // 넷빈즈 왼쪽 에러메세지 부분에서 Surround Statement with try-catch 메뉴로 자동생성하면 생성되는 메소드...에러가 발생하는 위치를 에러 메세지와 함께 콘솔에 출력한다.
            ex.printStackTrace(); //에러가 발생한 메소드의 호출기록 출력
        } finally {
            if(fos != null){
                fos.flush();
                fos.close();   //작업이 끝나면 파일을 닫아준다.
            } 
        }
    }
}
