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
            String msg = "�ȳ��ϼ���";
            //���� ������ ���ڿ� �����͸� ������ ���� �� � ��Ʈ���� ����ؾ� �ұ�
            pw = new PrintWriter(os,true);
            //������ �����͸� ����
            pw.println(msg);
            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            String servermsg = bis.readLine();
            
            System.out.println("���� :"+servermsg);
            
            
        } catch (IOException ex) {
            System.out.println("�������ӿ� ������ �߻��߽��ϴ�");
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