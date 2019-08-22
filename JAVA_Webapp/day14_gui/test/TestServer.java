/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author neo
 */
public class TestServer {
    private ServerSocket ss;
    private Properties prop;
    
    public TestServer(int port){
        
        try {
            prop = new Properties();
            ss = new ServerSocket(port);
            System.out.println("서버시작!");
            executeService();
        } catch (IOException ex) {
            System.out.println("해당 포트는 이미 사용중입니다.");
            ex.printStackTrace();
        } finally {
            try {
                if(!ss.isClosed()){
                    ss.close();
                }
            } catch (IOException ex) {
            }
        }
    }
    private void executeService() throws IOException{ //스
        while(true){
            Socket s = ss.accept();
            //접속한 클라이언트의 아이피를 확인
            InetSocketAddress isa = (InetSocketAddress)s.getRemoteSocketAddress();
                
            
        }
    }
}
