package ex1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

/* ���� �⺻���� ������ ��ɸ� ���� �������� ���α׷����� �н��Ѵ�.*/

/**
 * 
 * msg.propertis ������ �ۼ��Ѵ�.
 * ������ �����͸� key= value�� ����
 * 
 * ex)
 * hi = hello
 * bye = good bye!
 * Ŭ���̾�Ʈ GUI�� ���� msg�� ������ ������ msg.properties�� �޾Ƽ� 
 * Ŭ���̾�Ʈ�� �����ϸ� Ŭ���̾�Ʈ�� ������ ����޼����� �޾Ƽ� JTextArea�� ���
 * (�ɽ��� ����..)
 */
public class Exam_ServerSocketDemo {

    private ServerSocket ss;     // ������� �Ϸ��� �ʿ��� ��������.
    private Properties prop;     //������Ƽ ���� ����ϱ� ���� �ʵ忡 ����.
    public Exam_ServerSocketDemo(int port) {
        try {
            prop = new Properties();      //������Ƽ ��ü �����ϰ�
            //������ port ������ ���������� �����Ѵ�.
            ss = new ServerSocket(port);  //���� ���� ��ü ����, ��Ʈ��ȣ ������ �ְ�
            System.out.println("��������!");
            executeService();    
        } catch (IOException ex) {
            System.out.println("�ش� ��Ʈ�� �̹� ������Դϴ�.");
            ex.printStackTrace();
        } finally {
            try {
                if (!ss.isClosed()) {//������ �������� ���� ��� �ݾ��ش�.
                    ss.close();  //���� executeService ������ ������ ������ �ݾ��شٴ°�. 
                }
            } catch (IOException ex) {
            }
        }
    }

    private void executeService() throws IOException { //�����ڿ��� exception ó�� ���ֹǷ� thorws ����
        while (true) {//���񽺴� ���������� ����ؾ� �Ѵ�.
            Socket s = ss.accept();   //�ܺο��� ���Ͽ� �����Ҷ����� ����ϴ� �޼���.�ܺο��� �����ϸ�
                                       //������ �����ϰ� �� �ּҰ� s ���������� ����ȴ�.
                                       
            //������ Ŭ���̾�Ʈ�� �����Ǹ� Ȯ��
            InetSocketAddress isa = (InetSocketAddress) s.getRemoteSocketAddress();
            //Ŭ���̾�Ʈ �������κ��� ��û�� �޾Ƽ� �����ϴ� ����.
            
            InputStream is = s.getInputStream(); //�ܺο��� ���ӵǾ��ִ� �������κ��� �Է½�Ʈ���� ����
                                                 //Ŭ���̾�Ʈ���� ������ ������ �����͸� �޴´ٴ°�
                                                 
            OutputStream os = s.getOutputStream(); //�ܺη� �����͸� ����.
            
            PrintWriter pw = new PrintWriter(os,true); //���ڵ����͸� �����ϱ� ���� ���. 
            BufferedReader br = new BufferedReader(new FileReader("C:\\00_GUISpace\\day14_gui\\src\\ex1\\message.properties"));
           //BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\bigdataStudy\\java\\networkspace\\day14_gui\\src\\ex1\\message.properties"));
            
            //properties ������ ����ϱ� ���ؼ��� �ϴ� ������ �о�;��Ѵ�.
            //���� ������ ���� �Ǵµ� �ӵ� ���� ������Ʈ�� �ѹ� �� ���Ҵ�..
            //   in/out putStream �迭�� ����Ʈ(����,�̹���,���� ��)���� Ÿ���̰�, reader/writer �迭�� ����
            //   ����� ��Ʈ��.
            
            //������Ƽ ������ ����ϱ� ���� ��ü. 
            prop.load(br);    //load �޼ҵ�� �Ű����� ����� ������Ƽ ������ �о ������ ��ü�� ���� �����Ѵ�. 
            
            br.close();       //���� ��� �� �ݾ���.                  
            
           Scanner sc = new Scanner(is);  //��ĳ�ʷ� �ܺο��� �Է¹޴� �����͸� ���.
             //��ĳ�ʴ� ���۸� �����ϰ� ������, File �̳�, inputStream, Path �� �Ű������� ���� ���� �ִ�

           String msg = "";
           if (sc.hasNext()) {  //�Էµ� ���� ������ true��,������ false�� ��ȯ.
                //��ū�� ���๮�ڸ�(\n) �����ִ� ��쿡�� false�� ��ȯ������, ���๮�ڴ� �״�� �����ִ�.
                //�׷��ٸ� �Էµ� �� ���� ���͸� ġ�� ��� false �� �Űڱ�...

                msg = sc.nextLine();  //�� ��(���๮��,����)�� �������� �Է��� �޴´�.

                System.out.println("Client Message Log : " + msg);
            }
            msg = "Server : " +(String)prop.getProperty(msg,"�� �� ����"); //������Ƽ Ŭ������ get�޼ҵ�� �Է¹��� ���� �ش��ϴ� value���� �����Ѵ�.
            pw.println(msg);                          //Ŭ���̾�Ʈ�� ������ ����  
            System.out.println("������ IP :" + isa);
            sc.close(); //��ĳ�ʴ� ��Ʈ���� ����ϹǷ� ���� �ݾ������.
            s.close();  //���ϵ� �� ������ �ݾ���� ���� Ŭ���̾�Ʈ�� ������ �� �ְ���
            pw.close(); 
        }
    }

    public static void main(String[] args) {
        new Exam_ServerSocketDemo(9999); //��ü�����ϰ� ��Ʈ��ȣ �����ڿ� ����
    }

}
