/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class ServerThread implements Runnable{
    private Socket socket;
    private Ex1_Server server;
    private PrintWriter pw;
    private BufferedReader br;
    //서버에서 브로드캐스팅을 하기 위해서
    //클라이언트와 연결된 스트림으로 통신하기 위한
    //PrintWriter 의 주소를 제공한다.
     public PrintWriter getPw() {
        return pw;
    }
    public ServerThread(Socket socket , Ex1_Server server){
        this.socket = socket;
        this.server = server;
        System.out.println("접속자 IP :"+
                                    socket.getInetAddress().getHostAddress());  //소켓으로부터 ip주소를 얻어온다.
    }                                    //getInetAddress 메소드는 InetAddress 객체를 리턴한다. 

    @Override
    public void run() {
       
        try {
            pw = new PrintWriter(socket.getOutputStream(), true);  
            //PrintWriter 클래스는 생성자 중에 autoFlush 옵션이 있는 것이 있다. 
            //이 옵션이 true 값으로 설정되면 print() 또는 write() 메소드의 경우엔 상관없지만, println() 메소드가 호출되면 
            //자동으로 flush() 메소드를 호출한다. 이 옵션을 사용하면  빈번하게 버퍼를 비우는 경향이 있기도 하다.
            
            
            //readLine() 을 담당
            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));    //소켓의 OutputStream 을 받아서 읽는다.
            while(true){
                String clientMsg = br.readLine();        //읽은 데이터 저장하고
                System.out.println("Client Msg : "+clientMsg);   //콘솔에 출력
                server.sendMessage(clientMsg);           //
            }
        } catch (IOException ex) {
        }
    }
   
    
    
    
    
}
