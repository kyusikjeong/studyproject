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
    //�������� ��ε�ĳ������ �ϱ� ���ؼ�
    //Ŭ���̾�Ʈ�� ����� ��Ʈ������ ����ϱ� ����
    //PrintWriter �� �ּҸ� �����Ѵ�.
     public PrintWriter getPw() {
        return pw;
    }
    public ServerThread(Socket socket , Ex1_Server server){
        this.socket = socket;
        this.server = server;
        System.out.println("������ IP :"+
                                    socket.getInetAddress().getHostAddress());  //�������κ��� ip�ּҸ� ���´�.
    }                                    //getInetAddress �޼ҵ�� InetAddress ��ü�� �����Ѵ�. 

    @Override
    public void run() {
       
        try {
            pw = new PrintWriter(socket.getOutputStream(), true);  
            //PrintWriter Ŭ������ ������ �߿� autoFlush �ɼ��� �ִ� ���� �ִ�. 
            //�� �ɼ��� true ������ �����Ǹ� print() �Ǵ� write() �޼ҵ��� ��쿣 ���������, println() �޼ҵ尡 ȣ��Ǹ� 
            //�ڵ����� flush() �޼ҵ带 ȣ���Ѵ�. �� �ɼ��� ����ϸ�  ����ϰ� ���۸� ���� ������ �ֱ⵵ �ϴ�.
            
            
            //readLine() �� ���
            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));    //������ OutputStream �� �޾Ƽ� �д´�.
            while(true){
                String clientMsg = br.readLine();        //���� ������ �����ϰ�
                System.out.println("Client Msg : "+clientMsg);   //�ֿܼ� ���
                server.sendMessage(clientMsg);           //
            }
        } catch (IOException ex) {
        }
    }
   
    
    
    
    
}
