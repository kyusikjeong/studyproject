/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import thefrontproject.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class ClientMainThread_ver extends javax.swing.JFrame implements Runnable{
    private CardLayout card;  
    
    private MemberDataPojo mdata; //회원정보 Pojo
    private Socket s;         //통신을 담당하는 소켓
    private PrintWriter pw;   //데이터 보낼때 쓰는 프린터 롸이트
    
    private int menuNum=0; //이 번호는 스레드에게 시키는 일을 구분시키기 위해 사용한다. 버튼 누를 시 번호를 바꾸면서 조건문으로 하도록...일단 이렇게만 만들자.
    int totalNum,wordNum,winNum;      //회원의 푼 문제 총 수, 가입시 설정한 일일 출력되는 단어 수, 맞춘 총 문제수
    int x=100;     //그래프 좌표
    int y=300;     //좌표
    int width=0;   //너비
    int height=0;  //높이
    private ClientMainThread_ver client;
    private Thread t1,t2,t3,t4,t5;
    private FileManager fm;   //파일에 저장하고 출력하는 기능을 담당하는 클래스
    private DataService ds;
    /**
     * Creates new form Client
     */
    public ClientMainThread_ver() {
        initComponents();
        card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel,"averCard");
        fm = new FileManager();
        ds = new DataService(fm.getmQuestionList());
        try {
            s = new Socket("192.168.55.77",9999);     //접속할 대상의 ip 주소 및 포트번호
            pw = new PrintWriter(s.getOutputStream(),true);  //소켓 객체 안의 outputstream을 가져와서 출력하게 됨.
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        t1 = new Thread(this);  
        t2 = new Thread(){         
            public void run(){
                winNum = -100;
                height = 0;
                x  = 250;
                for(; height>=winNum; height-=10){
                    System.out.println("height 2 :"+height);
                //for(int i=0;i<=36;i++){
                    try {
                        drawGraph(200,100);
                        Thread.sleep(100); 
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        t3 = new Thread(){         
            public void run(){
                winNum = -100;
                height = 0;
                x  = 250;
                for(; height>=winNum; height-=10){
                    System.out.println("height 3 :"+height);
                //for(int i=0;i<=36;i++){
                    try {
                        drawGraph(300,100);
                        Thread.sleep(100); 
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };
        t4 = new Thread(){         
            public void run(){
                winNum = -100;
                height = 0;
                x  = 250;
                for(; height>=winNum; height-=10){
                    System.out.println("height 4 :"+height);
                //for(int i=0;i<=36;i++){
                    try {
                        drawGraph(400,100);
                        Thread.sleep(100); 
                    } catch (InterruptedException ex) {
                    }
                }
            }
        };

    }
    public synchronized void drawGraph(int x,int y){
      this.x = x;  
        
      averCanvas.repaint();
    }
    
//    public synchronized Thread threadRun(int inputX,int xx,int yy){   
//        
//        Thread thread = new Thread(){  //스레드 클래스로부터 직접 생성하는 방법중 하나. page 579
//                                           //현재 이 클래스는 Runnable 인터페이스를 구현한 클래스이고, main메서드에서 해당 객체를 생성했으므로
//                                           // 이 인스턴스를 가리키는 this를 전달해주면 스레드 클래스에서 Runnable 을 매개값으로 갖는 생성자를 호출하여 스레드를 사용할 수 있게된다. 
            
//            public void run(){
//                BufferedReader br;
//                try {
//                    br = new BufferedReader(
//                            new InputStreamReader(
//                                    s.getInputStream()));               //해당 참조변수로 넘어오는 데이터를 입력받는다.
//                    int dayWinNum = 0;
//                    winNum -= inputX;
//                     System.out.println("winNum "+winNum);
//                    x = xx; y = 300; //x축 y축
//                    System.out.println("x : "+x+" , y:"+y);
//                    height=0;    //길이
//                    width = 30;  //폭
//                    for(; height>=winNum; height-=10){
//                   // System.out.println("height :"+height);
//                        try {
//                            //System.out.println("-----");
//                            Thread.sleep(50);
//                             //Canvas 의 repaint() -> update() -> paint()
//                             averCanvas.repaint();
//                        } catch (InterruptedException ex) {
//                        }
//                    }
//                    winNum = 0;
//                    height=0;
//                   // br.close();
//               } catch (IOException ex) {
//                   ex.printStackTrace();
//                }
//            }
//        };
//        return thread;                  //위에서 이 작업을 하는 메소드를 가지고 있는 객체의 주소를 가지고 있는 thread 참조변수를 리턴. 
//                                        //스레드 객체는 메소드가 실행될때마다 새로 생성되므로 독립된 스레드들을 사용할 수 있다.
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        AveragePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        mainMoveBtn = new javax.swing.JButton();
        averCanvas = new java.awt.Canvas();
        monthAverBtn = new javax.swing.JButton();
        dayAverBtn = new javax.swing.JButton();
        QLabel5 = new javax.swing.JLabel();
        QLabel4 = new javax.swing.JLabel();
        QLabel2 = new javax.swing.JLabel();
        QLabel3 = new javax.swing.JLabel();
        QLabel1 = new javax.swing.JLabel();
        TodayQLabel = new javax.swing.JLabel();
        dQLabel_1 = new javax.swing.JLabel();
        dQLabel_2 = new javax.swing.JLabel();
        dQLabel_3 = new javax.swing.JLabel();
        dQLabel_4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpBtn2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jp3Btn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpBtn4 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(153, 153, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        AveragePanel.setBackground(new java.awt.Color(153, 204, 255));
        AveragePanel.setMinimumSize(new java.awt.Dimension(950, 600));

        jLabel4.setText("분석/average");

        mainMoveBtn.setText("메인으로");

        averCanvas = new java.awt.Canvas(){

            @Override
            public void update(Graphics g) {
                paint(g);
            }
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.green);
                g.fillRect(x, y, 10,height);
            }
        };
        averCanvas.setBackground(new java.awt.Color(204, 255, 204));

        monthAverBtn.setText("월간평균");
        monthAverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthAverBtnActionPerformed(evt);
            }
        });

        dayAverBtn.setText("일별 평균");
        dayAverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayAverBtnActionPerformed(evt);
            }
        });

        QLabel5.setText("Today-4 :");

        QLabel4.setText("Today-3 :");

        QLabel2.setText("Today-1 :");

        QLabel3.setText("Today-2 :");

        QLabel1.setText("Today :");

        TodayQLabel.setText("_____%");

        dQLabel_1.setText("_____%");

        dQLabel_2.setText("_____%");

        dQLabel_3.setText("_____%");

        dQLabel_4.setText("_____%");

        jLabel9.setFont(new java.awt.Font("함초롬바탕", 1, 14)); // NOI18N
        jLabel9.setText("Your Average");

        javax.swing.GroupLayout AveragePanelLayout = new javax.swing.GroupLayout(AveragePanel);
        AveragePanel.setLayout(AveragePanelLayout);
        AveragePanelLayout.setHorizontalGroup(
            AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AveragePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(averCanvas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AveragePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dayAverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(monthAverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(mainMoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(AveragePanelLayout.createSequentialGroup()
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AveragePanelLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(QLabel1)
                        .addGap(33, 33, 33)
                        .addComponent(TodayQLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(QLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dQLabel_1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(QLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dQLabel_2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AveragePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addGap(46, 46, 46)))
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AveragePanelLayout.createSequentialGroup()
                        .addComponent(QLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dQLabel_3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(QLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dQLabel_4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(65, 65, 65))
        );
        AveragePanelLayout.setVerticalGroup(
            AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AveragePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(QLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QLabel4)
                        .addComponent(dQLabel_3)
                        .addComponent(QLabel5)
                        .addComponent(dQLabel_4))
                    .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QLabel3)
                        .addComponent(dQLabel_2)
                        .addComponent(QLabel1)
                        .addComponent(TodayQLabel)
                        .addComponent(dQLabel_1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(averCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mainMoveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monthAverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayAverBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
        );

        mainPanel.add(AveragePanel, "averCard");

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("JOIN");

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jLabel5.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login Your Account");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(380, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(126, 126, 126))
        );

        mainPanel.add(jPanel1, "LoginCard");

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel2.setText("처음문제출력");

        jpBtn2.setText("jButton3");
        jpBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(601, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                .addComponent(jpBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        mainPanel.add(jPanel2, "c2");

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("panel3-문제푸는화면");

        jp3Btn.setText("jButton3");
        jp3Btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jp3BtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(711, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jp3Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 393, Short.MAX_VALUE)
                .addComponent(jp3Btn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        mainPanel.add(jPanel3, "c3");

        jPanel4.setBackground(new java.awt.Color(255, 204, 102));

        jLabel3.setText("result - 정답/오답");

        jpBtn4.setText("입력");
        jpBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn4ActionPerformed(evt);
            }
        });

        jLabel6.setText("문제1");

        jLabel7.setText("문제2");

        jLabel8.setText("문제3");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField3");

        jTextField5.setText("jTextField3");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(348, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                .addComponent(jpBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89))
        );

        mainPanel.add(jPanel4, "c4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          //  card.show(mainPanel,"averCard");  //수정해야함
      
       
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn2ActionPerformed
           // card.show(mainPanel,"c3");
    }//GEN-LAST:event_jpBtn2ActionPerformed

    private void jpBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn4ActionPerformed
              
        
        
        //card.show(mainPanel,"averCard");   //정답률분석 버튼 눌렀을시 화면 이동시키는 부분.
    }//GEN-LAST:event_jpBtn4ActionPerformed

    private void jp3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jp3BtnActionPerformed
          //문제입력 버튼을 눌렀을시 해당값을 파일에 전송하고 result 페이지에도 전송하는 부분 
       
        
        
        card.show(mainPanel,"c4");       //이 부분으로 이동할때 내가 개발할 데이터를 받아야함
    }//GEN-LAST:event_jp3BtnActionPerformed

    private void dayAverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayAverBtnActionPerformed
            ArrayList<MemberQuestionPojo> mqlist = ds.mSearchQuestion("test1");
            
            
            
          
            Vector v = new Vector();  //평균값을 합산해서 끝부터 출력하기 위해 벡터를 사용. 
            for(MemberQuestionPojo mq : mqlist){ //해당하는 아이디가 가지고 있는 문제 풀이 데이터를 다 불러와서 돌림
                System.out.println("test :" + mq.getId()+ " , "+mq.getDate() + " ,"+mq.getWordNum()+ " ,"+
                                  mq.getDwinNum()+ " ,"+mq.getwTotalNum()+" , "+mq.getWinNum());
                float aver = (float)mq.getDwinNum()/mq.getWordNum() * 100;   //평균값을 구함 
               
                v.add(aver);  //벡터에 더하고..
                          
            }   
                int idx = 1;   //가장 최근 데이터가 마지막에 저장되기 때문에, 라벨에 배열에 마지막 인덱스 값을 빼기 위해 일단 변수 선언    
                
                TodayQLabel.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0) +"%")); idx++;   //벡터 사이즈 -1이 벡터 끝 인덱스이므로 끝 인덱스면 해당값 저장하고 아니면 0을 저장
                dQLabel_1.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;     //그 뒤 인덱스를 증가시켜서 1씩 추가로 감소하게 함
                dQLabel_2.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;
                dQLabel_3.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;
                dQLabel_4.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); 
                
            System.out.println("printing btn");    
            int totalNum,wordNum,winNum; 

//            pw.println("test");
            //임시로 코드 붙여놓음
            System.out.println("222222222222");
//            t1 = client.threadRun(50, 100, 100);
//            t2 = client.threadRun(60, 200, 100);
//            t3= client.threadRun(70, 300, 100);
                
                client.t1.start();
        try {
                System.out.println("1");
                client.t1.join();
                System.out.println("2");
                client.t2.start();
                System.out.println("3");
                client.t2.join();
                
                client.t3.start();
                System.out.println("4");
                client.t3.join();
                client.t4.start();
                
            } catch (InterruptedException ex) {
            }
    }//GEN-LAST:event_dayAverBtnActionPerformed

    private void monthAverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthAverBtnActionPerformed
        //월간 평균 데이터 출력 부분.
        int tMonth = ds.qMonthAverage("test1");
        
        TodayQLabel.setText(String.valueOf(tMonth)+"%");
       
        
        
        dQLabel_1.setText("_____%");
        dQLabel_2.setText("_____%");
        dQLabel_3.setText("_____%");
        dQLabel_4.setText("_____%");
        QLabel1.setText("이번달");
        QLabel2.setText("1달전");
        QLabel3.setText("2달전");
        QLabel4.setText("3달전");
        QLabel5.setText("4달전");
        
    }//GEN-LAST:event_monthAverBtnActionPerformed
    public void setInstance(ClientMainThread_ver c){
        client = c;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("printing btn main");  
        ClientMainThread_ver client = new ClientMainThread_ver(); 
       
        System.out.println("printing btn new");  
        /* Create and display the form */
        client.setInstance(client);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                client.setVisible(true);
            }
            
        });
//        try {
//            client.t1.start();
//            client.t1.join();
//            client.t2.start();
//        } catch (InterruptedException ex) {
//        }
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AveragePanel;
    private javax.swing.JLabel QLabel1;
    private javax.swing.JLabel QLabel2;
    private javax.swing.JLabel QLabel3;
    private javax.swing.JLabel QLabel4;
    private javax.swing.JLabel QLabel5;
    private javax.swing.JLabel TodayQLabel;
    private java.awt.Canvas averCanvas;
    private javax.swing.JLabel dQLabel_1;
    private javax.swing.JLabel dQLabel_2;
    private javax.swing.JLabel dQLabel_3;
    private javax.swing.JLabel dQLabel_4;
    private javax.swing.JButton dayAverBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton jp3Btn;
    private javax.swing.JButton jpBtn2;
    private javax.swing.JButton jpBtn4;
    private javax.swing.JButton mainMoveBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton monthAverBtn;
    // End of variables declaration//GEN-END:variables

    @Override 
    public  void run() {
         winNum = -80;
         height = 0;
         for(; height>=winNum; height-=10){
                    System.out.println("height main:"+height);
            try {
                drawGraph(100,100);
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
}
