package ex1;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ex1_SocketClientDemo {
    private Socket s;

    public Ex1_SocketClientDemo(String host, int port) { //�ڽ��� ������, ��Ʈ��ȣ�� �Ű�����...��
        try {
            s= new Socket(host, port); //    
        } catch (IOException ex) {
            System.out.println("�������ӿ� ������ �߻��߽��ϴ�");
            ex.printStackTrace();
        }
        
    }
    public static void main(String[] args) {
        new Ex1_SocketClientDemo("192.168.0.41", 9999);
    }
    
    
    
}