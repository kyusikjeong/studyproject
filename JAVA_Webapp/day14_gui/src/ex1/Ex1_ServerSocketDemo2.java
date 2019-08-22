package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/* ���� �⺻���� ������ ��ɸ� ���� �������� ���α׷����� �н��Ѵ�.*/
public class Ex1_ServerSocketDemo2 {

    private ServerSocket ss;

    public Ex1_ServerSocketDemo2(int port) {
        try {
            //������ port ������ ���������� �����Ѵ�.
            ss = new ServerSocket(port);
            System.out.println("��������!");
            executeService();
        } catch (IOException ex) {
            System.out.println("�ش� ��Ʈ�� �̹� ������Դϴ�.");
            ex.printStackTrace();
        } finally {
            try {
                if (!ss.isClosed()) {//������ �������� ���� ��� �ݾ��ش�.
                    ss.close();
                }
            } catch (IOException ex) {
            }
        }
    }

    private void executeService() throws IOException {
        while (true) {//���񽺴� ���������� ����ؾ� �Ѵ�.
            Socket s = ss.accept();
            //������ Ŭ���̾�Ʈ�� �����Ǹ� Ȯ��
            InetSocketAddress isa = (InetSocketAddress) s.getRemoteSocketAddress();
            //Ŭ���̾�Ʈ �������κ��� ��û�� �޾Ƽ� �����ϴ� ����.
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

//            BufferedReader bis = new BufferedReader(new InputStreamReader(is));
            Scanner sc = new Scanner(is);
            
            try {
                if (sc.hasNext()) {
                    String msg = sc.nextLine();
                    System.out.println("Client Message Log : " + msg);
                }

                System.out.println("������ IP :" + isa);
                s.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Ex1_ServerSocketDemo2(9999);
    }

}
