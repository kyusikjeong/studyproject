
package ex1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * server : socket -> [bind() -> listen()] -> accept()-> stream() -> close();
 *                       �����Ҷ� ����ȿ���� ��.
 *bind() portsocket �� ���� ������ �Ҵ�
 * listen() : Ŭ���̾�Ʈ�� ���� ��û�� Ȯ��
 * accept() : Ŭ���̾�Ʈ�� ������ ����
 * Ex1_Server 
 * 1.ServerSocket�� �����Ѵ�
 * 2.accpet() ȣ���ؼ� ���ӵ� Socket�� ��ȯ�Ѵ�.
 * 2-1 ���� �����ڸ� ó���ϱ� ���ؼ� ArrayList�� ����Ѵ�. //�������� �ּҸ� �����ֱ� ����. �����ϱ� ����.
 * 3.Socket ���� �����ϴ� Stream ���� ����Ѵ�. // 
 * 3-1 readLine()�� ������� Thread�� �����Ѵ�.//readline ��ü�� ���� ���ŷ�̶� ������� �����尡 �ʿ�. ���ϼ���ŭ...
 * ���� / Ư���� ��û�� ���� ���� GUI �� ������ ���������� �ʴ´�. //
 * @author KOSTA
 */
public class Ex1_Server {
    //���ۼ��� 1.ServerSocket �����ϰ� �����Ѵ�.
    private ServerSocket ss;
    //2-1�� ���� ����
    private ArrayList<ServerThread> cList;      //�������� �ּ� ������ ����...
    //Thread Group �� �����ϱ� ���� pool
    private ExecutorService executorService;
    public Ex1_Server(){
        try {
            ss = new ServerSocket(9999);
             System.out.println("Server Start!");
             cList = new ArrayList<>();                         
             executorService = Executors.newFixedThreadPool(3); //Ǯ�� ������ ������.�̻��¿����� ��������� ���� �� �ְ��� 
        } catch (IOException ex) {
            System.out.println("�̹� ������� port�Դϴ�.");
        }
    }
    
    public void execute(){
        //�����ؼ� Socket �� �޴� ���񽺸� �ؾ��Ѵ�.
        //2.accept()ȣ���ؼ� ���ӵ� Socket�� ��ȯ�Ѵ�.
        while(true){
            //****Socket�� �ϳ��� ���Ӹ��� ����Ѵ�.
            //����ڿ��� ������ ������ Thread�� ���� �����ؼ�
            //Start() �ϸ鼭, ������� ������ �ּҰ��� 
            //ArrayList �����ߴ�.
            Socket s;
            try {
                s = ss.accept();
                ServerThread ct = new ServerThread(s,this);    //�ش� Ŭ������ �����带 ���ٴ°��� Runnalble �������̽��� �����ߴٴ� ���̴�.
                                                            //���� ������ �ް� �ش� ��ü(Ex1_server)�� �ּҸ� ��������..
                executorService.submit(ct);                 //���������� �����ϰ� �� ��ü�ּҸ� submit �޼��忡 ����. ȣ��
                //Thread t = new Thread(ct);
                cList.add(ct);                              //arraylist�� ������ ServerThread��ü �ּҸ� ����. 
                                    //�����ڵ鰣 �����带 �ϳ��� ��ü �����ϰ� �� �ּҸ� ����Ʈ�� ����
                //t.start();
                System.out.println("Current number of clients : "
                                              + cList.size()); //�����ڵ��� ���� ���
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
    }
        public static void main(String[] args) {
            Ex1_Server server = new Ex1_Server();
            server.execute();                      //�޼��� ����. �ٷ� ����...
        }
        
        public void sendMessage(String clientMsg){
            //���ӵ� ����ڴ� ArrayList�� ����Ǿ� �ֱ� ������
            //�� ����ڿ��� ����� �ؼ� �޼����� ���� �����Ѵ�.
            for(ServerThread e : cList){        
                e.getPw().println(clientMsg);   //ServerThread ��ü �ȿ� PrintWriter �ּҸ� ���Ϲ���. PrintWriter ��ü�� println�޼��� ����
            }
        }
}
