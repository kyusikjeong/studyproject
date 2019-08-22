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
    private String userId;  //�α��� ������ �ӽ� ������ �������̵�
    //�������� ��ε�ĳ������ �ϱ� ���ؼ�
    //Ŭ���̾�Ʈ�� ����� ��Ʈ������ ����ϱ� ����
    //PrintWriter �� �ּҸ� �����Ѵ�.
     public PrintWriter getPw() {
        return pw;
    }
    public ServerThread(Socket socket , Server server){
        this.socket = socket;
        this.server = server;
        mdata = new MemberDataPojo();
        fm = new FileManager();
        ds = new DataService();
        
        System.out.println("������ IP :"+
                                    socket.getInetAddress().getHostAddress());  //�������κ��� ip�ּҸ� ���´�.
    }                                    //getInetAddress �޼ҵ�� InetAddress ��ü�� �����Ѵ�. 

    @Override
    public void run() {
       
        try {
        
            pw = new PrintWriter(socket.getOutputStream(), true);   
            br = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()));    //������ OutputStream �� �޾Ƽ� �д´�.
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());   //Ŭ���̾�Ʈ�� ��ü�� ������ ���ؼ� ����Ѵ�.

            ///////////////////////////////////////while start 
            while(true){
                    String clientData = br.readLine();        //���� ������ �����ϰ�
                    if(clientData.equals("dAver")){
                        os.writeObject(ds.qDayAverage("test1"));   //ó������ �����ϸ� �α��� �ܰ迡�� ���� �ޱ⶧����
                                                                    //userId�� ������ �Ǵµ�, ���⼱ ���κκ� �ÿ��� �ؾ��ϹǷ� 
                                                                    //�ӽ÷� test1 ���̵��� �����͸� �ҷ������� ����.
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
                        os.writeObject(true); //�ӽ÷� �ο�
                        os.flush();
                    }
                } 

            
        } catch (IOException ex) {
        }
    }
}
