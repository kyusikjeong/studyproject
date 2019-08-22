package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_SocketClientDemo2 {
    private Socket s;
    private PrintWriter pw;
    public Ex1_SocketClientDemo2(String host, int port) {
        try {
            s= new Socket(host, port);
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            String msg = "안녕하세요";
            //한줄 단위로 문자열 데이터를 보내고 싶을 때 어떤 스트림을 사용해야 할까
            pw = new PrintWriter(os,true);
            //서버로 데이터를 전송
            pw.println(msg);
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            String servermsg = bis.readLine();
            
            System.out.println("응답 :"+servermsg);
            
            
        } catch (IOException ex) {
            System.out.println("서버접속에 문제가 발생했습니다");
            ex.printStackTrace();
        } finally {
             try {
                if(!s.isClosed()){
                 pw.close();
                 s.close();
                }
             }
             catch (IOException ex) {
                 Logger.getLogger(Ex1_SocketClientDemo2.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            }
        }
  
    public static void main(String[] args) {
        new Ex1_SocketClientDemo2("192.168.0.41", 9999);
    }
    
    
    
}