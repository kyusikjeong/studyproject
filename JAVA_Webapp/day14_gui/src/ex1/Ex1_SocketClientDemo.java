package ex1;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_SocketClientDemo {
    private Socket s;

    public Ex1_SocketClientDemo(String host, int port) { //자신의 아이피, 포트번호가 매개변수...군
        try {
            s= new Socket(host, port); //    
        } catch (IOException ex) {
            System.out.println("서버접속에 문제가 발생했습니다");
            ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new Ex1_SocketClientDemo("192.168.0.41", 9999);
    }
    
    
    
}