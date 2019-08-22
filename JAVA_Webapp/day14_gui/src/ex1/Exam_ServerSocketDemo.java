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

/* 가장 기본적인 서버의 기능만 갖춘 서버소켓 프로그래밍을 학습한다.*/

/**
 * 
 * msg.propertis 파일을 작성한다.
 * 응답할 데이터를 key= value로 저장
 * 
 * ex)
 * hi = hello
 * bye = good bye!
 * 클라이언트 GUI로 부터 msg를 받으면 서버는 msg.properties를 받아서 
 * 클라이언트로 전송하면 클라이언트는 서버의 응답메세지를 받아서 JTextArea에 출력
 * (심심이 같은..)
 */
public class Exam_ServerSocketDemo {

    private ServerSocket ss;     // 서버통신 하려면 필요한 서버소켓.
    private Properties prop;     //프로퍼티 파일 사용하기 위해 필드에 선언.
    public Exam_ServerSocketDemo(int port) {
        try {
            prop = new Properties();      //프로퍼티 객체 생성하고
            //지정된 port 값으로 서버소켓을 생성한다.
            ss = new ServerSocket(port);  //서버 소켓 객체 생성, 포트번호 받은거 넣고
            System.out.println("서버시작!");
            executeService();    
        } catch (IOException ex) {
            System.out.println("해당 포트는 이미 사용중입니다.");
            ex.printStackTrace();
        } finally {
            try {
                if (!ss.isClosed()) {//서버가 닫혀있지 않은 경우 닫아준다.
                    ss.close();  //위의 executeService 수행이 끝나면 서버를 닫아준다는것. 
                }
            } catch (IOException ex) {
            }
        }
    }

    private void executeService() throws IOException { //생성자에서 exception 처리 해주므로 thorws 해줌
        while (true) {//서비스는 지속적으로 대기해야 한다.
            Socket s = ss.accept();   //외부에서 소켓에 접속할때까지 대기하는 메서드.외부에서 접근하면
                                       //소켓을 리턴하고 그 주소가 s 참조변수에 저장된다.
                                       
            //접속한 클라이언트의 아이피를 확인
            InetSocketAddress isa = (InetSocketAddress) s.getRemoteSocketAddress();
            //클라이언트 소켓으로부터 요청을 받아서 응답하는 구조.
            
            InputStream is = s.getInputStream(); //외부에서 접속되어있는 소켓으로부터 입력스트림을 받음
                                                 //클라이언트에서 서버로 던지는 데이터를 받는다는것
                                                 
            OutputStream os = s.getOutputStream(); //외부로 데이터를 보냄.
            
            PrintWriter pw = new PrintWriter(os,true); //문자데이터를 전송하기 위해 사용. 
            BufferedReader br = new BufferedReader(new FileReader("C:\\00_GUISpace\\day14_gui\\src\\ex1\\message.properties"));
           //BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\bigdataStudy\\java\\networkspace\\day14_gui\\src\\ex1\\message.properties"));
            
            //properties 파일을 사용하기 위해서는 일단 파일을 읽어와야한다.
            //파일 리더만 쓰면 되는데 속도 빠른 보조스트림 한번 써 보았다..
            //   in/out putStream 계열은 바이트(영상,이미지,음악 등)전송 타입이고, reader/writer 계열은 문자
            //   입출력 스트림.
            
            //프로퍼티 파일을 사용하기 위한 객체. 
            prop.load(br);    //load 메소드는 매개변수 경로의 프로퍼티 파일을 읽어서 생성한 객체에 값을 저장한다. 
            
            br.close();       //버퍼 사용 후 닫아줌.                  
            
           Scanner sc = new Scanner(is);  //스캐너로 외부에서 입력받는 데이터를 사용.
             //스캐너는 버퍼를 내장하고 있으며, File 이나, inputStream, Path 를 매개변수로 받을 수도 있다

           String msg = "";
           if (sc.hasNext()) {  //입력된 값이 있으면 true를,없으면 false를 반환.
                //토큰에 개행문자만(\n) 남아있는 경우에는 false를 반환하지만, 개행문자는 그대로 남아있다.
                //그렇다면 입력된 값 없이 엔터만 치면 계속 false 란 거겠군...

                msg = sc.nextLine();  //한 줄(개행문자,엔터)을 기준으로 입력을 받는다.

                System.out.println("Client Message Log : " + msg);
            }
            msg = "Server : " +(String)prop.getProperty(msg,"알 수 없음"); //프로퍼티 클래스의 get메소드는 입력받은 값에 해당하는 value값을 리턴한다.
            pw.println(msg);                          //클라이언트에 데이터 보냄  
            System.out.println("접속자 IP :" + isa);
            sc.close(); //스캐너는 스트림을 사용하므로 쓰고 닫아줘야함.
            s.close();  //소켓도 다 썼으면 닫아줘야 다음 클라이언트가 접속할 수 있겠지
            pw.close(); 
        }
    }

    public static void main(String[] args) {
        new Exam_ServerSocketDemo(9999); //객체생성하고 포트번호 생성자에 던짐
    }

}
