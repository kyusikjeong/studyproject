/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import thefrontproject.*;
import java.awt.CardLayout;
import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.awt.Graphics;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.io.Serializable;
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
public class Client01_21_ThreadErrVer extends javax.swing.JFrame implements Runnable,Serializable{
    private CardLayout card;  
    
    private MemberDataPojo mdata; //ȸ������ Pojo
    private Socket s;         //����� ����ϴ� ����
    private PrintWriter pw;   //������ ������ ���� ������ ����Ʈ
    
    
    private int menuNum=0; //�� ��ȣ�� �����忡�� ��Ű�� ���� ���н�Ű�� ���� ����Ѵ�. ��ư ���� �� ��ȣ�� �ٲٸ鼭 ���ǹ����� �ϵ���...�ϴ� �̷��Ը� ������.
    int totalNum,wordNum,winNum;      //ȸ���� Ǭ ���� �� ��, ���Խ� ������ ���� ��µǴ� �ܾ� ��, ���� �� ������
    int x=0;     //�׷��� ��ǥ
    int y=0;     //��ǥ
    int width=0;   //�ʺ�
    int height=0;  //����
    int arcAngle=0;
    private String str="";  //�׷��� ���ڿ�
    private String type;   //�۾��� �� ���ǹ��� ����ϱ� ���� ����. 
    private Client01_21_ThreadErrVer client;
    private Thread t1,t2,t3,t4,t5;
    private FileManager fm;   //���Ͽ� �����ϰ� ����ϴ� ����� ����ϴ� Ŭ����
    private DataService ds;
    private Graphics g;
    private Thread ex;
   private ObjectInputStream ois;
    

    public void setType(String type) {
        this.type = type;
    }
    
    private Object tobject;
    public Vector v;
    /**
     * Creates new form Client
     */
    public Client01_21_ThreadErrVer() {
        initComponents();
        card = (CardLayout)mainPanel.getLayout();
        card.show(mainPanel,"averCard");
        g= averCanvas.getGraphics();
        fm = new FileManager();
        ds = new DataService(fm.getmQuestionList());
        
        try {
            s = new Socket("localhost",9999);     //������ ����� ip �ּ� �� ��Ʈ��ȣ
            pw = new PrintWriter(s.getOutputStream(),true);  //���� ��ü ���� outputstream�� �����ͼ� ����ϰ� ��.
            ois = new ObjectInputStream(s.getInputStream());
            ex=new Thread(){
          @Override
          public void run(){
               try {
                    //ObjectInputStream ois2 = new ObjectInputStream(s.getInputStream());
//                    br = new BufferedReader(
//                            new InputStreamReader(
//                                    s.getInputStream()));               //�ش� ���������� �Ѿ���� �����͸� �Է¹޴´�.
//                  String type=br.readLine();^
                   
                    tobject = null;
                    System.out.println("--------1");
                      
                      System.out.println("tobject" + tobject);
                      
                      tobject = (Object)ois.readObject();
                      if (type.equals("dAver")){
                          System.out.println("--------2");
                          v = new Vector();
                          v =(Vector)tobject;
                          qDayLabelSetText();
                      } else if (type.equals("mAver")){
                          System.out.println("--------3");
                         // System.out.println(""+Integer.parseInt(tobject.toString()));
                         //qMonthLabelSetText();
                      }
                } catch (IOException ex) {
                    Logger.getLogger(Client01_21_ThreadErrVer.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex1) {
                  Logger.getLogger(Client01_21_ThreadErrVer.class.getName()).log(Level.SEVERE, null, ex1);
              }
            }
        };
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public synchronized void drawArc(int x,int y,int width,int height,int arcAngle){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.arcAngle = arcAngle;
        
        averCanvas.repaint();
       
    }
    
    public synchronized Thread threadRun(String type){
        //�����尡 �ϴ����� ���������ֱ� ���ؼ� �����ڸ� �Է¹ް� �ϴ� �����
        //�����غ���.
        
//        Thread thread = new Thread(client){  //������ Ŭ�����κ��� ���� �����ϴ� ����� �ϳ�. page 579
//                                           //���� �� Ŭ������ Runnable �������̽��� ������ Ŭ�����̰�, main�޼��忡�� �ش� ��ü�� ���������Ƿ�
//                                           // �� �ν��Ͻ��� ����Ű�� this�� �������ָ� ������ Ŭ�������� Runnable �� �Ű������� ���� �����ڸ� ȣ���Ͽ� �����带 ����� �� �ְԵȴ�. 
//            //g.fillArc(350,80,200, 200, 80, arcAngle);
//            public void run(){
//            
//                
//               try {
//                    //ObjectInputStream ois2 = new ObjectInputStream(s.getInputStream());
////                    br = new BufferedReader(
////                            new InputStreamReader(
////                                    s.getInputStream()));               //�ش� ���������� �Ѿ���� �����͸� �Է¹޴´�.
////                  String type=br.readLine();^
//                   
//                    tobject = null;
//                    System.out.println("--------1");
//                      
//                      System.out.println("tobject" + tobject);
//                      
//                      tobject = (Object)ois.readObject();
//                      if (type.equals("dAver")){
//                          System.out.println("--------2");
//                          v = new Vector();
//                          v =(Vector)tobject;
//                          qDayLabelSetText();
//                      } else if (type.equals("mAver")){
//                          System.out.println("--------3");
//                         // System.out.println(""+Integer.parseInt(tobject.toString()));
//                         //qMonthLabelSetText();
//                      }
//                } catch (IOException ex) {
//                } catch (ClassNotFoundException ex) {
//                }
//            }
//        };
        Thread thread = ex;
        return thread;                  //������ �� �۾��� �ϴ� �޼ҵ带 ������ �ִ� ��ü�� �ּҸ� ������ �ִ� thread ���������� ����. 
                                        //������ ��ü�� �޼ҵ尡 ����ɶ����� ���� �����ǹǷ� ������ ��������� ����� �� �ִ�.
    }
    
    
    
    ////////////////////////////////////Method line//////////////////////////////////////////// 
    public void qDayLabelSetText(){  //��ܿ� �ִ� �󺧿� �ϰ� ��� ������ ������ֱ� ���� �޼���
        int idx = 1;   //���� �ֱ� �����Ͱ� �������� ����Ǳ� ������, �󺧿� �迭�� ������ �ε��� ���� ���� ���� �ϴ� ���� ����    
        int vsize = (v.size()<5? v.size(): 5);  //�ϰ� �����Ͱ� 5������ ��µǹǷ�, �̾ƿ� �����Ͱ� 5�� �̻��̸� 5��, �� �̸��̸� ���� ����� ������ ��������
        //�뵵�� �Ʒ����� ������ ���� �� ��ŭ ����� ���ϴ� �ݺ����� ������ ����.
        TodayQLabel.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0) +"%")); idx++;   //���� ������ -1�� ���� �� �ε����̹Ƿ� �� �ε����� �ش簪 �����ϰ� �ƴϸ� 0�� ����
        dQLabel_1.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;     //�� �� �ε����� �������Ѽ� 1�� �߰��� �����ϰ� ��
        dQLabel_2.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;
        dQLabel_3.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;
        dQLabel_4.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); 
        
        QLabel1.setText("Today :");  //�ش� �󺧵��� ��հ� ���� �ȳ� �󺧵�.
        QLabel2.setText("Today-1:");
        QLabel3.setText("Today-2");
        QLabel4.setText("Today-3");
        QLabel5.setText("Today-4");
        idx = 1;
        int average=0;
        
        for(;idx<= vsize;idx++){
            System.out.println("count"+idx);
            System.out.println(v.get(v.size()-idx >=0 ?v.size()-idx : 0) +"%");
            average += Integer.parseInt(v.get(v.size()-idx >=0 ?v.size()-idx : 0).toString());
        }
        drawArc(average/vsize);
    }
    
    public void qMonthLabelSetText(int average){ //��ܿ� ���� ��� �����͸� ������ֱ� ���� �޼���
        TodayQLabel.setText(String.valueOf("")+"%");
        dQLabel_1.setText("_____%");
        dQLabel_2.setText("_____%");
        dQLabel_3.setText("_____%");
        dQLabel_4.setText("_____%");
        QLabel1.setText("�̹���");
        QLabel2.setText("1����");
        QLabel3.setText("2����");
        QLabel4.setText("3����");
        QLabel5.setText("4����");
        
    }
    
    public void drawArc(int average){
        int num =  (int) (average * 3.6);    //��հ� ���ϴ� �κ�. �Ű������� �ʿ��� ���� ���޹޵��� �����ؾ� �Ѵ�.
        str = String.valueOf(average+"%");
        System.out.println("num   : "+num);

        for(; arcAngle<=num; arcAngle+=10){
       // System.out.println("height :"+height);
            try {
                 drawArc(350,80,200,200,arcAngle);
                 System.out.println("-----");
                 Thread.sleep(50);
                 //Canvas �� repaint() -> update() -> paint()
            } catch (InterruptedException ex) {
            }
        }
        arcAngle = 0;
    }
    
    public void clearCanvas(){  //ĵ������ �����
        g.clearRect(0, 0, averCanvas.getWidth(), averCanvas.getHeight()); 
    }
    
    
    
    
    
    
    ////////////////////////////////////Method line//////////////////////////////////////////// 
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

        AveragePanel.setBackground(new java.awt.Color(255, 153, 153));
        AveragePanel.setMinimumSize(new java.awt.Dimension(950, 600));

        jLabel4.setText("�м�/average");

        mainMoveBtn.setText("��������");

        averCanvas = new java.awt.Canvas(){

            @Override
            public void update(Graphics g) {
                paint(g);
            }
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.white);
                g.fillArc(x,y,width, height, 80, arcAngle);
                g.drawString(str, 320, 100);

                //g.fillArc(x, y, width, height, startAngle, arcAngle);
                // g.fillRect(x, y, 30,height);
            }
        };
        averCanvas.setBackground(new java.awt.Color(0, 102, 102));

        monthAverBtn.setText("�������");
        monthAverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthAverBtnActionPerformed(evt);
            }
        });

        dayAverBtn.setText("�Ϻ� ���");
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

        jLabel9.setFont(new java.awt.Font("���ʷҹ���", 1, 14)); // NOI18N
        jLabel9.setText("Your Average");

        javax.swing.GroupLayout AveragePanelLayout = new javax.swing.GroupLayout(AveragePanel);
        AveragePanel.setLayout(AveragePanelLayout);
        AveragePanelLayout.setHorizontalGroup(
            AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AveragePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AveragePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AveragePanelLayout.createSequentialGroup()
                        .addComponent(averCanvas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel5.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
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

        jLabel2.setText("ó���������");

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

        jLabel1.setText("panel3-����Ǫ��ȭ��");

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

        jLabel3.setText("result - ����/����");

        jpBtn4.setText("�Է�");
        jpBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn4ActionPerformed(evt);
            }
        });

        jLabel6.setText("����1");

        jLabel7.setText("����2");

        jLabel8.setText("����3");

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
          //  card.show(mainPanel,"averCard");  //�����ؾ���
      
       
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn2ActionPerformed
           // card.show(mainPanel,"c3");
    }//GEN-LAST:event_jpBtn2ActionPerformed

    private void jpBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn4ActionPerformed
              
        
        
        //card.show(mainPanel,"averCard");   //������м� ��ư �������� ȭ�� �̵���Ű�� �κ�.
    }//GEN-LAST:event_jpBtn4ActionPerformed

    private void jp3BtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jp3BtnActionPerformed
          //�����Է� ��ư�� �������� �ش簪�� ���Ͽ� �����ϰ� result ���������� �����ϴ� �κ� 
       
        
        
        card.show(mainPanel,"c4");       //�� �κ����� �̵��Ҷ� ���� ������ �����͸� �޾ƾ���
    }//GEN-LAST:event_jp3BtnActionPerformed

    private void dayAverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayAverBtnActionPerformed
            
            clearCanvas();
            System.out.println("test1");
            pw.println("dAver");
            System.out.println("test2");
            t5 = client.threadRun("dAver");
            System.out.println("test3");
            t5.start();   //�����带 ������ �����κ��� �޾ƿ� �����͸� ����
            System.out.println("test4");
         
//            System.out.println("printing btn");    
//            int totalNum,wordNum,winNum; 
//
////            pw.println("test");
//            //�ӽ÷� �ڵ� �ٿ�����
//            System.out.println("222222222222");
//            
//            t1 = client.threadRun(50);
//            t2 = client.threadRun(60);
//            t3= client.threadRun(70);
//                
//                t1.start();
//            try {
//                System.out.println("1");
//                t1.join();
//                System.out.println("2");
//                t2.start();
//                System.out.println("3");
//                
//            } catch (InterruptedException ex) {
//            }
    }//GEN-LAST:event_dayAverBtnActionPerformed

    private void monthAverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthAverBtnActionPerformed
        //���� ��� ������ ��� �κ�.
        clearCanvas();
        pw.println("mAver");
        
        t4= client.threadRun("mAver");
          
        t4.start();
         System.out.println("monthAverBtnActionPerformed");
    }//GEN-LAST:event_monthAverBtnActionPerformed
    public void setInstance(Client01_21_ThreadErrVer c){
        client = c;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.out.println("printing btn main");  
        Client01_21_ThreadErrVer client = new Client01_21_ThreadErrVer(); 
       
        System.out.println("printing btn new");  
        /* Create and display the form */
        client.setInstance(client);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                client.setVisible(true);
            }
            
        });
        
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
         winNum = -50;
         height = 0;
         for(; height>=winNum; height-=10){
                    System.out.println("height main:"+height);
            try {
                //drawGraph(250,100);
                Thread.sleep(300);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
}
