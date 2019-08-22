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
            System.out.println("��������!");
            executeService();
        } catch (IOException ex) {
            System.out.println("�ش� ��Ʈ�� �̹� ������Դϴ�.");
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
    private void executeService() throws IOException{ //��
        while(true){
            Socket s = ss.accept();
            //������ Ŭ���̾�Ʈ�� �����Ǹ� Ȯ��
            InetSocketAddress isa = (InetSocketAddress)s.getRemoteSocketAddress();
                
            
        }
    }
}
