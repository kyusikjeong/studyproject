package ex1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* 가장 기본적인 서버의 기능만 갖춘 서버소켓 프로그래밍을 학습한다.*/
public class Ex1_ServerSocketDemo {
    
    private ServerSocket ss;

    public Ex1_ServerSocketDemo(int port) {
        try {
            //지정된 port 값으로 서버소켓을 생성한다.
            ss=new ServerSocket(port);
            System.out.println("서버시작!");
            executeService();
        } catch (IOException ex) {
            System.out.println("해당 포트는 이미 사용중입니다.");
            ex.printStackTrace();
        }finally{
            try {
                if(!ss.isClosed()){//서버가 닫혀있지 않은 경우 닫아준다.
                ss.close();
                }
            } catch (IOException ex) {
            }
        }
    }
    private void executeService() throws IOException {
        while(true){//서비스는 지속적으로 대기해야 한다.
            Socket s = ss.accept();
            //접속한 클라이언트의 아이피를 확인
            InetSocketAddress isa = (InetSocketAddress) s.getRemoteSocketAddress();
            //클라이언트 소켓으로부터 요청을 받아서 응답하는 구조.
            System.out.println("접속자 IP :"+isa);
        }
    }
    public static void main(String[] args) {
        new Ex1_ServerSocketDemo(9999);
    }
    
}