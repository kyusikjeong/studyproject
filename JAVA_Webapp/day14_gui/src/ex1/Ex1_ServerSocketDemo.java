package ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* ���� �⺻���� ������ ��ɸ� ���� �������� ���α׷����� �н��Ѵ�.*/
public class Ex1_ServerSocketDemo {
    
    private ServerSocket ss;

    public Ex1_ServerSocketDemo(int port) {
        try {
            //������ port ������ ���������� �����Ѵ�.
            ss=new ServerSocket(port);
            System.out.println("��������!");
            executeService();
        } catch (IOException ex) {
            System.out.println("�ش� ��Ʈ�� �̹� ������Դϴ�.");
            ex.printStackTrace();
        }finally{
            try {
                if(!ss.isClosed()){//������ �������� ���� ��� �ݾ��ش�.
                ss.close();
                }
            } catch (IOException ex) {
            }
        }
    }
    private void executeService() throws IOException {
        while(true){//���񽺴� ���������� ����ؾ� �Ѵ�.
            Socket s = ss.accept();
            //������ Ŭ���̾�Ʈ�� �����Ǹ� Ȯ��
            InetSocketAddress isa = (InetSocketAddress) s.getRemoteSocketAddress();
            //Ŭ���̾�Ʈ �������κ��� ��û�� �޾Ƽ� �����ϴ� ����.
            System.out.println("������ IP :"+isa);
        }
    }
    public static void main(String[] args) {
        new Ex1_ServerSocketDemo(9999);
    }
    
}