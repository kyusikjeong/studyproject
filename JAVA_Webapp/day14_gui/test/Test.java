


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Test {
    public static void main(String[] args) throws IOException {
           Scanner sc = new Scanner(System.in);  //스캐너로 외부에서 입력받는 데이터를 사용.
             //스캐너는 버퍼를 내장하고 있으며, File 이나, inputStream, Path 를 매개변수로 받을 수도 있다

           String msg = "";
           if (sc.hasNext()) {  //입력된 값이 있으면 true를,없으면 false를 반환.
                //토큰에 개행문자만(\n) 남아있는 경우에는 false를 반환하지만, 개행문자는 그대로 남아있다.

                msg = sc.nextLine();  //한 줄(개행문자,엔터)을 기준으로 입력을 받는다.

                System.out.println("Client Message Log : " + msg);
            }
            
            
    }
}
