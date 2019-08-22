
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
 *                       접속할때 완충효과를 함.
 *bind() portsocket 에 대한 정보를 할당
 * listen() : 클라이언트의 접속 요청을 확인
 * accept() : 클라이언트의 소켓을 생성
 * Ex1_Server 
 * 1.ServerSocket을 생성한다
 * 2.accpet() 호출해서 접속된 Socket을 반환한다.
 * 2-1 다중 접속자를 처리하기 위해서 ArrayList를 사용한다. //접속자의 주소를 지켜주기 위해. 유지하기 위해.
 * 3.Socket 에서 제공하는 Stream 으로 통신한다. // 
 * 3-1 readLine()을 담당해줄 Thread를 제작한다.//readline 자체가 단일 블록킹이라 담당해줄 스레드가 필요. 소켓수만큼...
 * 참고 / 특별한 요청이 없을 때는 GUI 로 서버를 제작하지는 않는다. //
 * @author KOSTA
 */
public class Ex1_Server {
    //제작순서 1.ServerSocket 선언하고 생성한다.
    private ServerSocket ss;
    //2-1을 위한 선언
    private ArrayList<ServerThread> cList;      //접속자의 주소 유지를 위한...
    //Thread Group 을 관리하기 위한 pool
    private ExecutorService executorService;
    public Ex1_Server(){
        try {
            ss = new ServerSocket(9999);
             System.out.println("Server Start!");
             cList = new ArrayList<>();                         
             executorService = Executors.newFixedThreadPool(3); //풀의 갯수를 제한함.이상태에서는 세명까지만 들어올 수 있겠지 
        } catch (IOException ex) {
            System.out.println("이미 사용중인 port입니다.");
        }
    }
    
    public void execute(){
        //지속해서 Socket 을 받는 서비스를 해야한다.
        //2.accept()호출해서 접속된 Socket을 반환한다.
        while(true){
            //****Socket은 하나의 접속만을 담당한다.
            //사용자에게 응답을 위임한 Thread를 각각 생성해서
            //Start() 하면서, 사용자의 소켓의 주소값을 
            //ArrayList 저장했다.
            Socket s;
            try {
                s = ss.accept();
                ServerThread ct = new ServerThread(s,this);    //해당 클래스가 스레드를 쓴다는것은 Runnalble 인터페이스를 구현했다는 것이다.
                                                            //소켓 정보를 받고 해당 객체(Ex1_server)의 주소를 가져간다..
                executorService.submit(ct);                 //서버스레드 생성하고 그 객체주소를 submit 메서드에 보냄. 호출
                //Thread t = new Thread(ct);
                cList.add(ct);                              //arraylist에 생성된 ServerThread객체 주소를 더함. 
                                    //접속자들간 스레드를 하나씩 객체 생성하고 그 주소를 리스트에 저장
                //t.start();
                System.out.println("Current number of clients : "
                                              + cList.size()); //접속자들의 숫자 출력
            } catch (IOException ex) {
                ex.printStackTrace();
            }
         }
    }
        public static void main(String[] args) {
            Ex1_Server server = new Ex1_Server();
            server.execute();                      //메서드 실행. 바로 위의...
        }
        
        public void sendMessage(String clientMsg){
            //접속된 사용자는 ArrayList에 저장되어 있기 때문에
            //그 사용자에게 통신을 해서 메세지를 각각 전송한다.
            for(ServerThread e : cList){        
                e.getPw().println(clientMsg);   //ServerThread 객체 안에 PrintWriter 주소를 리턴받음. PrintWriter 객체의 println메서드 실행
            }
        }
}
