/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefrontproject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class ServerThread implements Runnable,Serializable{
    private Socket socket;
    private Server server;
    private PrintWriter pw;
    private BufferedReader br;
    private MemberDataPojo mdata;
    private FileManager fm;
    private PrintStream ps ;
    private DataService ds;
    private ArrayList<MemberQuestionPojo> mqlist;
    private String userId;  //로그인 성공시 임시 저장할 유저아이디
    //서버에서 브로드캐스팅을 하기 위해서
    //클라이언트와 연결된 스트림으로 통신하기 위한
    //PrintWriter 의 주소를 제공한다.
     public PrintWriter getPw() {
        return pw;
    }
    public ServerThread(Socket socket , Server server){
        this.socket = socket;
        this.server = server;
        mdata = new MemberDataPojo();
        fm = new FileManager();
        ds = new DataService();
        
        System.out.println("접속자 IP :"+
                                    socket.getInetAddress().getHostAddress());  //소켓으로부터 ip주소를 얻어온다.
    }                                    //getInetAddress 메소드는 InetAddress 객체를 리턴한다. 

    @Override
    public void run() {
       
        try {
        
            pw = new PrintWriter(socket.getOutputStream(), true);   
            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));    //소켓의 OutputStream 을 받아서 읽는다.
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());   //클라이언트로 객체를 보내기 위해서 사용한다.

            ///////////////////////////////////////while start 
            while(true){
                    String clientData = br.readLine();        //읽은 데이터 저장하고
                    if(clientData.equals("dAver")){
                        os.writeObject(ds.qDayAverage("test1"));   //처음부터 시작하면 로그인 단계에서 값을 받기때문에
                                                                    //userId를 받으면 되는데, 여기선 개인부분 시연을 해야하므로 
                                                                    //임시로 test1 아이디의 데이터를 불러오도록 선언.
                        os.flush();
                    } else if(clientData.equals("mAver")){
                         os.writeObject(ds.qMonthAverage("test1"));
                         os.flush();
                    } else if(clientData.equals("questionList")){
                        os.writeObject(ds.randomQuizList());
                        os.flush();

                    } else if(clientData.startsWith("memberJoin")){
                        fm.idServerCheck(clientData);
                       
                     
                    } else if(clientData.startsWith("Login")){
                        boolean tb = fm.idPwCheck(clientData);
                        os.writeObject(tb);
                        if(tb == true){
                              userId = fm.getUserId();
                        }
                        os.flush();
                    } else if(clientData.startsWith("updateInfo")){
                        os.writeObject(fm.mSearchList(userId));
                        os.flush();
                    } else if(clientData.startsWith("infoUpdate")){
                        fm.updateMemberFile(clientData);
                        os.writeObject(true); //임시로 부여
                        os.flush();
                    }
                } 

            
        } catch (IOException ex) {
        }
    }
}
