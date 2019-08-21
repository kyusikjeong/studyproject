/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Ex5_Demo {

 
    public static void main(String[] args) {
        try {
            BufferedReader br = null;
            String path="https://news.naver.com/main/read.nhn?oid=052&sid1=103&aid=0001240445&mid=shm&mode=LSD&nh=20190114114615";
            URL url = new URL(path);
           
            //어쩔수 없이 바이트 스트림으로 받아온 객체를
            //문자스트림으로 변경하려고 할 때가 있다.
            //InputStreamReader(inputStream,인코딩)
            // => Scanner 로 대체 가능하다.(InputStreamReader x)            //윈도우 같은 경우 temperary? 임시 폴더에 값이 저장되는데 그걸 읽어온다.
            //연습문제: Scanner 의 API 참고해서
            //똑같은 기능으로 Ex5_ScannerDemo에서 구현하시오
            //url.openStream() : InputStream  내부의 소스를 불러온다.
            br = new BufferedReader(
                    new InputStreamReader(url.openStream(),"euc-kr"));  //내부의 소스를 euc-kr형식으로 인코딩
            String str = null;
            while((str = br.readLine()) != null){
                System.out.println(str);
            }
        } catch (IOException ex) {
            
        }
}
}
