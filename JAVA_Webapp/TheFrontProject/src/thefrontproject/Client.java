package thefrontproject;


import conn.MyConn;
import java.awt.CardLayout;
import java.awt.Color;
import static java.awt.Frame.NORMAL;
import java.awt.Graphics;
import java.awt.Toolkit;
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
import javax.swing.JOptionPane;

public class Client extends javax.swing.JFrame implements Runnable,Serializable{
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
    int arcAngle=0;        //�׷������� �� �׸��� ä������ ����. 360 �̸� ������ ����.
    private String str="";  //�׷��� ���ڿ�. ĵ������ �׷����� �׷��� ���� % ����
    private String type;   //�۾��� �� ���ǹ��� ����ϱ� ���� ����. 
    private Client client;  
    private Thread t1,t2;  //�׸� �׸��� ���� ������.
   
    
    private Graphics g;      
    private Thread mainThread;  //��� ����� ���� ����� ������.
    private int count=0;    //���ν����带 �ѹ��� ������ ���� ī��Ʈ����. �ι� ������ �������⿡ �ѹ��� ����
    private ObjectInputStream ois;   //���ν����忡�� ��ü�� ������ ������ ������Ʈ ��Ʈ���� �����
    
    private Object tobject;  //���ν����忡�� ���޹��� ������Ʈ�� �ޱ� ���� ����
    private Vector v;        //�ϰ� ��� 5���� ���Ѱ��� ������ ���� ���޹��� ���ͺ���
    private boolean flag = true;
    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
        card = (CardLayout)mainPanel.getLayout();
        // card.show(mainPanel,"averCard");  //������Ʈ �ÿ��� ���� ���⼭ ����
        card.show(mainPanel,"LoginCard");
        
        
        g = averCanvas.getGraphics();
        try {
            s = new Socket("localhost",9998);     //������ ����� ip �ּ� �� ��Ʈ��ȣ
            pw = new PrintWriter(s.getOutputStream(),true);  //���� ��ü ���� outputstream�� �����ͼ� ����ϰ� ��.
            ois = new ObjectInputStream(s.getInputStream());
            mainThread=new Thread(){
          @Override
          public void run(){ /////////////////////////////////////////////////////////////////////////////////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/��ܽ�����
               try {
                    while(true){
                      tobject = (Object)ois.readObject();  //�����κ��� ���� ������Ʈ ���. 
                      if (type.equals("dAver")){
                          v = new Vector();               
                          v =(Vector)tobject;           // �����迭�� ����ϰ�, �迭�� �� ������ ���� ������ַ��� ���͸� ����� ���Ҵ�.
                          qDayLabelSetText();           //�� �޼ҵ带 �����ؼ� ��ܿ� �ֱ� 5ȸ���� �����
                                                        // ����ϰ� �߾ӿ� �׷����� �׸���.
                      } else if (type.equals("mAver")){
                        qMonthLabelSetText(Integer.parseInt(tobject.toString())); //���� ��� �׷���
                      } 
                    //////////////////////////////////////////////////////////////////////  
                      
                      
                      else if(type.equals("questionList")){
                        try {
                              mainThread.sleep(500);
                          } catch (InterruptedException ex) {
                             ex.printStackTrace();
                          }
                        quizAreaSetText((ArrayList)tobject);
                     } else if(type.equals("Login")){
                          mainThread.sleep(500);
                          pageMove((boolean)tobject);
                     } else if(type.equals("updateInfo")){
                          
                          updatePageSetText((ArrayList)tobject);
                     } 
                   
                    }
         
               } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex1) {
              } catch (InterruptedException ex) {
              }
            }
        };
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
   
    
    public synchronized Thread threadRun(){ /////////////////////////////////////////////-----------------------------------------------------------------------------------------
       
        Thread thread = new Thread(client){  //������ Ŭ�����κ��� ���� �����ϴ� ����� �ϳ�. page 579
                                           //���� �� Ŭ������ Runnable �������̽��� ������ Ŭ�����̰�, main�޼��忡�� �ش� ��ü�� ���������Ƿ�
                                           // �� �ν��Ͻ��� ����Ű�� this�� �������ָ� ������ Ŭ�������� Runnable �� �Ű������� ���� �����ڸ� ȣ���Ͽ� �����带 ����� �� �ְԵȴ�. 
            //g.fillArc(350,80,200, 200, 80, arcAngle);
            public void run(){
                if (type.equals("dAver")){
                    qDayLabelSetText();
                 } else if (type.equals("mAver")){
                    qMonthLabelSetText(Integer.parseInt(tobject.toString()));   //�����κ��� ���� ��հ��� ������Ʈ Ÿ������ �޾ƿͼ�, ��ȯ�Ͽ� �޼ҵ����
                 }
            }
        };
        return thread;                  //������ �� �۾��� �ϴ� �޼ҵ带 ������ �ִ� ��ü�� �ּҸ� ������ �ִ� thread ���������� ����. 
                                        //������ ��ü�� �޼ҵ尡 ����ɶ����� ���� �����ǹǷ� ������ ��������� ����� �� �ִ�.
    }
    
    ////////////////////////////////////Method line/////////////////////////////////////////////////////////////// /////////////////// /////////////////// /////////////////// ///////////////////  
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
        
        for(;idx<= vsize;idx++){ //������ �����ŭ �ݺ��ϰ� �ϰ� ���� ��� �����͸� ���ؼ� ����� ����.
            average += Integer.parseInt(v.get(v.size()-idx >=0 ?v.size()-idx : 0).toString());  
                //���� �ȿ� ����ִ� ���� �� �����鼭 ���Ͽ� ��հ��� ���ϴµ�,  ������ �ε����� ���Ҷ� ���� �����ڸ� ����Ͽ�
                //���� ���� 0����ũ�� ��� ���ҽ�Ű�鼭 ���� �̰�, 0�̵Ǹ� 0�������� ���� �����鼭 ������.
        }
        drawArc(average/vsize);   //���� ������� ����� �������� ���� �׸��� �޼���
    }
    
    public void qMonthLabelSetText(int average){ //��ܿ� ���� ��� �����͸� ������ֱ� ���� �޼���
        TodayQLabel.setText("_____");
        dQLabel_1.setText("_____");
        dQLabel_2.setText(String.valueOf(average)+"%");
        dQLabel_3.setText("_____");
        dQLabel_4.setText("_____");
        QLabel1.setText("______");
        QLabel2.setText("______");
        QLabel3.setText("---���� ���---");
        QLabel4.setText("______");
        QLabel5.setText("______");
        drawArc(average);
        
    }
    public synchronized void drawArc(int x,int y,int width,int height,int arcAngle){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.arcAngle = arcAngle;
        
        averCanvas.repaint();
       
    }
    public void drawArc(int average){       //���� ������Ű�鼭 
        int num =  (int) (average * 3.6);    //��հ� ���ϴ� �κ�. �Ű������� �ʿ��� ���� ���޹޵��� �����ؾ� �Ѵ�.
        str = String.valueOf(average+"%");
        
        for(; arcAngle<=num; arcAngle+=10){
       // System.out.println("height :"+height);
            try {
                
                 averCanvas.repaint();
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
    
    public void quizAreaSetText(ArrayList<QuizWordPojo> list){
        
        for(QuizWordPojo qw : list){
          
             target.append(qw.getWord()+":"+qw.getMean()+"\n");
        }
    }
    
    public void quizTextFieldText(){
        ArrayList<QuizWordPojo> list = (ArrayList)tobject;
       
            
        q1Label.setText(list.get(0).getWord());
        q2Label.setText(list.get(1).getWord());
        q3Label.setText(list.get(2).getWord());
        q4Label.setText(list.get(3).getWord());
        q5Label.setText(list.get(4).getWord());
    }
    public void quizResultLabelText(String[] tword){
        card.show(mainPanel,"qExamResultCard");  
        ArrayList<QuizWordPojo> list = (ArrayList)tobject;
    
        qRLabel1.setText(list.get(0).getWord());  //�ܾ� ����
        qRLabel2.setText(list.get(1).getWord());
        qRLabel3.setText(list.get(2).getWord());
        qRLabel4.setText(list.get(3).getWord());
        qRLabel5.setText(list.get(4).getWord());
        
        qRMeanLa.setText(list.get(0).getMean());  //�� ����
        qRMeanLa2.setText(list.get(1).getMean());
        qRMeanLa3.setText(list.get(2).getMean());
        qRMeanLa4.setText(list.get(3).getMean());
        qRMeanLa5.setText(list.get(4).getMean());
        
        qResult1.setText(list.get(0).getMean().equals(tword[0]) ? "�����Դϴ�.": "�����Դϴ�.");
        qResult2.setText(list.get(1).getMean().equals(tword[1]) ? "�����Դϴ�.": "�����Դϴ�.");
        qResult3.setText(list.get(2).getMean().equals(tword[2]) ? "�����Դϴ�.": "�����Դϴ�.");
        qResult4.setText(list.get(3).getMean().equals(tword[3]) ? "�����Դϴ�.": "�����Դϴ�.");
        qResult5.setText(list.get(4).getMean().equals(tword[4]) ? "�����Դϴ�.": "�����Դϴ�.");
        
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public void pageMove(Boolean b){
          if(b == true){
              card.show(mainPanel,"c2");
          } else{
              System.out.println("Error");
          }
    }
    
    public void updatePageSetText(ArrayList arr){
            ArrayList<MemberDataPojo> mlist = arr;
            mUpdateLabel.setText(mlist.get(0).getId());
            joinTextField11.setText(mlist.get(0).getName());
            joinTextField12.setText(mlist.get(0).getSchool());
            
    }
        
    ////////////////////////////////////Method line////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor. 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog3 = new javax.swing.JDialog();
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
        idLoginTextF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pwLoginTextF = new javax.swing.JPasswordField();
        userPagePanel = new javax.swing.JPanel();
        LoginBeforeLa = new javax.swing.JLabel();
        jpBtn2 = new javax.swing.JButton();
        updateInfoBtn = new javax.swing.JButton();
        questionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        questionBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionArea = new javax.swing.JTextArea();
        qExamPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jpBtn4 = new javax.swing.JButton();
        q1Label = new javax.swing.JLabel();
        q2Label = new javax.swing.JLabel();
        q3Label = new javax.swing.JLabel();
        q1TextF = new javax.swing.JTextField();
        q2TextF = new javax.swing.JTextField();
        q3TextF = new javax.swing.JTextField();
        q4Label = new javax.swing.JLabel();
        q5Label = new javax.swing.JLabel();
        q4TextF = new javax.swing.JTextField();
        q5TextF = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        qExamResultPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        qRLabel1 = new javax.swing.JLabel();
        qRLabel2 = new javax.swing.JLabel();
        qRLabel3 = new javax.swing.JLabel();
        qRLabel4 = new javax.swing.JLabel();
        qRLabel5 = new javax.swing.JLabel();
        qRMeanLa4 = new javax.swing.JLabel();
        qRMeanLa5 = new javax.swing.JLabel();
        qRMeanLa3 = new javax.swing.JLabel();
        qRMeanLa2 = new javax.swing.JLabel();
        qRMeanLa = new javax.swing.JLabel();
        qResult1 = new javax.swing.JLabel();
        qResult2 = new javax.swing.JLabel();
        qResult3 = new javax.swing.JLabel();
        qResult4 = new javax.swing.JLabel();
        qResult5 = new javax.swing.JLabel();
        joinPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        j = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        joinTextField1 = new javax.swing.JTextField();
        joinTextField2 = new javax.swing.JTextField();
        joinTextField3 = new javax.swing.JTextField();
        joinTextField5 = new javax.swing.JTextField();
        joinTextField6 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        infoUpdatePanel = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        j1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        joinTextField8 = new javax.swing.JTextField();
        joinTextField9 = new javax.swing.JTextField();
        joinTextField11 = new javax.swing.JTextField();
        joinTextField12 = new javax.swing.JTextField();
        mUpdateLabel = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        studyPage = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        target = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        countLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog3Layout = new javax.swing.GroupLayout(jDialog3.getContentPane());
        jDialog3.getContentPane().setLayout(jDialog3Layout);
        jDialog3Layout.setHorizontalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog3Layout.setVerticalGroup(
            jDialog3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(153, 153, 255));
        mainPanel.setLayout(new java.awt.CardLayout());

        AveragePanel.setBackground(new java.awt.Color(255, 153, 153));
        AveragePanel.setMinimumSize(new java.awt.Dimension(950, 600));

        jLabel4.setText("�м�/average");

        mainMoveBtn.setBackground(new java.awt.Color(255, 255, 153));
        mainMoveBtn.setText("��������");
        mainMoveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainMoveBtnActionPerformed(evt);
            }
        });

        averCanvas = new java.awt.Canvas(){

            @Override
            public void update(Graphics g) {
                paint(g);
            }
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.white);
                g.fillArc(350,80,200,200,50,arcAngle);
                g.drawString(str, 320, 100);

                //g.fillArc(x, y, width, height, startAngle, arcAngle);
                // g.fillRect(x, y, 30,height);
            }
        };
        averCanvas.setBackground(new java.awt.Color(0, 102, 102));

        monthAverBtn.setBackground(new java.awt.Color(255, 255, 153));
        monthAverBtn.setText("�������");
        monthAverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthAverBtnActionPerformed(evt);
            }
        });

        dayAverBtn.setBackground(new java.awt.Color(255, 255, 153));
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
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(51, 153, 255));
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 153, 255));
        jButton2.setText("JOIN");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        idLoginTextF.setPreferredSize(new java.awt.Dimension(10, 25));
        idLoginTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idLoginTextFActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login Your Account");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thefrontproject/image/150_200 loginImage1.png"))); // NOI18N

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/thefrontproject/image/150_200 loginImage2.png"))); // NOI18N

        pwLoginTextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwLoginTextFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(376, 376, 376)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pwLoginTextF))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(idLoginTextF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(342, 342, 342))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel5)
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(idLoginTextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pwLoginTextF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(69, 69, 69)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1, "LoginCard");

        userPagePanel.setBackground(new java.awt.Color(102, 153, 255));

        LoginBeforeLa.setText("�α��� ����");

        jpBtn2.setText("����Ǯ��");
        jpBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn2ActionPerformed(evt);
            }
        });

        updateInfoBtn.setText("��������");
        updateInfoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInfoBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout userPagePanelLayout = new javax.swing.GroupLayout(userPagePanel);
        userPagePanel.setLayout(userPagePanelLayout);
        userPagePanelLayout.setHorizontalGroup(
            userPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userPagePanelLayout.createSequentialGroup()
                .addContainerGap(424, Short.MAX_VALUE)
                .addGroup(userPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LoginBeforeLa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(userPagePanelLayout.createSequentialGroup()
                        .addComponent(updateInfoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jpBtn2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(90, 90, 90))
        );
        userPagePanelLayout.setVerticalGroup(
            userPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPagePanelLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(LoginBeforeLa, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 331, Short.MAX_VALUE)
                .addGroup(userPagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(updateInfoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpBtn2, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addGap(65, 65, 65))
        );

        mainPanel.add(userPagePanel, "c2");

        questionPanel.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setText("panel3-����Ǫ��ȭ��");

        questionBtn.setText("����Ǯ��");
        questionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionBtnActionPerformed(evt);
            }
        });

        questionArea.setColumns(20);
        questionArea.setFont(new java.awt.Font("�޸ո���ü", 1, 24)); // NOI18N
        questionArea.setRows(5);
        jScrollPane1.setViewportView(questionArea);

        javax.swing.GroupLayout questionPanelLayout = new javax.swing.GroupLayout(questionPanel);
        questionPanel.setLayout(questionPanelLayout);
        questionPanelLayout.setHorizontalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, questionPanelLayout.createSequentialGroup()
                .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(questionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(questionPanelLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 844, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(61, 61, 61))
        );
        questionPanelLayout.setVerticalGroup(
            questionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(questionPanelLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(questionBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        mainPanel.add(questionPanel, "c3");

        qExamPanel.setBackground(new java.awt.Color(255, 204, 102));

        jLabel3.setText("result - ����/����");

        jpBtn4.setText("��������");
        jpBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn4ActionPerformed(evt);
            }
        });

        q1Label.setText("����1");

        q2Label.setText("����2");

        q3Label.setText("����3");

        q1TextF.setPreferredSize(new java.awt.Dimension(67, 30));
        q1TextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1TextFActionPerformed(evt);
            }
        });

        q2TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        q3TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        q4Label.setText("����4");

        q5Label.setText("����5");

        q4TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        q5TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        jButton3.setText("��պ���");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout qExamPanelLayout = new javax.swing.GroupLayout(qExamPanel);
        qExamPanel.setLayout(qExamPanelLayout);
        qExamPanelLayout.setHorizontalGroup(
            qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qExamPanelLayout.createSequentialGroup()
                .addGap(296, 296, 296)
                .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(qExamPanelLayout.createSequentialGroup()
                        .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(q1Label, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(q2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(q3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(q4Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(q5Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(q5TextF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(q3TextF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(q4TextF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(q1TextF, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(q2TextF, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(qExamPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpBtn4, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(121, 121, 121))
        );
        qExamPanelLayout.setVerticalGroup(
            qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qExamPanelLayout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(qExamPanelLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q2Label)
                            .addComponent(q2TextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(q1Label)
                    .addComponent(q1TextF, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q3TextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q3Label))
                .addGap(35, 35, 35)
                .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q4TextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q4Label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q5TextF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q5Label, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(qExamPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpBtn4, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                .addGap(89, 89, 89))
        );

        mainPanel.add(qExamPanel, "c4");

        qExamResultPanel.setBackground(new java.awt.Color(255, 153, 153));
        qExamResultPanel.setMaximumSize(new java.awt.Dimension(1200, 1200));

        jLabel6.setFont(new java.awt.Font("����", 1, 18)); // NOI18N
        jLabel6.setText("Y o u r      R e s u l t");

        jButton4.setText("��躸��");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("�ٽ��ϱ�");

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));

        qRLabel1.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRLabel1.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel1.setText("jLabel10");

        qRLabel2.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRLabel2.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel2.setText("jLabel11");

        qRLabel3.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRLabel3.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel3.setText("jLabel12");

        qRLabel4.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRLabel4.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel4.setText("jLabel13");

        qRLabel5.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRLabel5.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel5.setText("jLabel14");

        qRMeanLa4.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRMeanLa4.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa4.setText("jLabel18");

        qRMeanLa5.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRMeanLa5.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa5.setText("jLabel19");

        qRMeanLa3.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRMeanLa3.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa3.setText("jLabel17");

        qRMeanLa2.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRMeanLa2.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa2.setText("jLabel16");

        qRMeanLa.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qRMeanLa.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa.setText("jLabel15");

        qResult1.setBackground(new java.awt.Color(255, 255, 255));
        qResult1.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qResult1.setForeground(new java.awt.Color(255, 255, 255));
        qResult1.setText("jLabel20");

        qResult2.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qResult2.setForeground(new java.awt.Color(255, 255, 255));
        qResult2.setText("jLabel21");

        qResult3.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qResult3.setForeground(new java.awt.Color(255, 255, 255));
        qResult3.setText("jLabel22");

        qResult4.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qResult4.setForeground(new java.awt.Color(255, 255, 255));
        qResult4.setText("jLabel23");

        qResult5.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        qResult5.setForeground(new java.awt.Color(255, 255, 255));
        qResult5.setText("jLabel24");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(184, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(qRLabel2)
                    .addComponent(qRLabel1)
                    .addComponent(qRLabel3)
                    .addComponent(qRLabel4)
                    .addComponent(qRLabel5))
                .addGap(116, 116, 116)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(qRMeanLa)
                    .addComponent(qRMeanLa2)
                    .addComponent(qRMeanLa3)
                    .addComponent(qRMeanLa4)
                    .addComponent(qRMeanLa5))
                .addGap(114, 114, 114)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qResult1, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(qResult2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qResult3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qResult4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qResult5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(113, 113, 113))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qRMeanLa)
                            .addComponent(qResult1))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qRMeanLa2)
                            .addComponent(qResult2))
                        .addGap(29, 29, 29)
                        .addComponent(qRMeanLa3)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(qRMeanLa4)
                            .addComponent(qResult4))
                        .addGap(28, 28, 28)
                        .addComponent(qRMeanLa5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(qRLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(qRLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(qRLabel3)
                        .addGap(32, 32, 32)
                        .addComponent(qRLabel4)
                        .addGap(28, 28, 28)
                        .addComponent(qRLabel5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(qResult3)
                        .addGap(75, 75, 75)
                        .addComponent(qResult5)))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout qExamResultPanelLayout = new javax.swing.GroupLayout(qExamResultPanel);
        qExamResultPanel.setLayout(qExamResultPanelLayout);
        qExamResultPanelLayout.setHorizontalGroup(
            qExamResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qExamResultPanelLayout.createSequentialGroup()
                .addGap(302, 302, 302)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(131, 131, 131)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(274, 274, 274))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qExamResultPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(qExamResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qExamResultPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(373, 373, 373))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, qExamResultPanelLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))))
        );
        qExamResultPanelLayout.setVerticalGroup(
            qExamResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(qExamResultPanelLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(qExamResultPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        mainPanel.add(qExamResultPanel, "qExamResultCard");

        joinPanel.setBackground(new java.awt.Color(255, 153, 153));

        jPanel3.setBackground(new java.awt.Color(0, 102, 51));

        j.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        j.setForeground(new java.awt.Color(255, 255, 255));
        j.setText("I        D");
        j.setMaximumSize(new java.awt.Dimension(45, 20));
        j.setMinimumSize(new java.awt.Dimension(45, 20));
        j.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel11.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("��й�ȣ");
        jLabel11.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel11.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel11.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel13.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("�̸�");
        jLabel13.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel14.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("����ʵ��б�");
        jLabel14.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel14.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel14.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel15.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("��й�ȣȮ��");

        joinTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                joinTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(joinTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinTextField6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(156, 156, 156))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(168, Short.MAX_VALUE))
        );

        jButton6.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        jButton6.setText("ȸ������");
        jButton6.setActionCommand("��      ��");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout joinPanelLayout = new javax.swing.GroupLayout(joinPanel);
        joinPanel.setLayout(joinPanelLayout);
        joinPanelLayout.setHorizontalGroup(
            joinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joinPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(joinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        joinPanelLayout.setVerticalGroup(
            joinPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(joinPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        mainPanel.add(joinPanel, "joinCard");

        infoUpdatePanel.setBackground(new java.awt.Color(255, 153, 153));

        jPanel4.setBackground(new java.awt.Color(0, 102, 51));

        j1.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        j1.setForeground(new java.awt.Color(255, 255, 255));
        j1.setText("I        D");
        j1.setMaximumSize(new java.awt.Dimension(45, 20));
        j1.setMinimumSize(new java.awt.Dimension(45, 20));
        j1.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel16.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("��й�ȣ");
        jLabel16.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel16.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel16.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel18.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("�̸�");
        jLabel18.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel19.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("����ʵ��б�");
        jLabel19.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel19.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel19.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel20.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("��й�ȣȮ��");

        mUpdateLabel.setFont(new java.awt.Font("����", 1, 12)); // NOI18N
        mUpdateLabel.setForeground(new java.awt.Color(255, 255, 255));
        mUpdateLabel.setText("I        D");
        mUpdateLabel.setMaximumSize(new java.awt.Dimension(45, 20));
        mUpdateLabel.setMinimumSize(new java.awt.Dimension(45, 20));
        mUpdateLabel.setPreferredSize(new java.awt.Dimension(45, 20));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(247, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(joinTextField8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                    .addComponent(joinTextField9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinTextField11, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(joinTextField12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mUpdateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(156, 156, 156))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mUpdateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(joinTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(159, Short.MAX_VALUE))
        );

        jButton7.setFont(new java.awt.Font("����", 1, 14)); // NOI18N
        jButton7.setText("��������");
        jButton7.setActionCommand("��      ��");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout infoUpdatePanelLayout = new javax.swing.GroupLayout(infoUpdatePanel);
        infoUpdatePanel.setLayout(infoUpdatePanelLayout);
        infoUpdatePanelLayout.setHorizontalGroup(
            infoUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoUpdatePanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(infoUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        infoUpdatePanelLayout.setVerticalGroup(
            infoUpdatePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoUpdatePanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        mainPanel.add(infoUpdatePanel, "updateCard");

        studyPage.setBackground(new java.awt.Color(136, 207, 207));

        jButton8.setText("TEST START");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("WORD OF THE DAY");

        target.setColumns(20);
        target.setRows(5);
        jScrollPane2.setViewportView(target);

        jLabel10.setText("�����ð� : ");

        countLabel.setText("jLabel4");

        javax.swing.GroupLayout studyPageLayout = new javax.swing.GroupLayout(studyPage);
        studyPage.setLayout(studyPageLayout);
        studyPageLayout.setHorizontalGroup(
            studyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studyPageLayout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(studyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(studyPageLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(countLabel)))
                .addGap(24, 24, 24))
            .addGroup(studyPageLayout.createSequentialGroup()
                .addGap(368, 368, 368)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        studyPageLayout.setVerticalGroup(
            studyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, studyPageLayout.createSequentialGroup()
                .addGroup(studyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(studyPageLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(studyPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(countLabel))
                        .addGap(39, 39, 39)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(studyPageLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)))
                .addGap(36, 36, 36))
        );

        mainPanel.add(studyPage, "card2");

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
          // �α��� ��ư ������ �� ����
          type ="Login";
        
          pw.println("Login"+"/"+idLoginTextF.getText()+"/"+pwLoginTextF.getText());
          
          if(count ==0){
            mainThread.start();   //�����带 ������ �����κ��� �޾ƿ� �����͸� ����
            count++;
          }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn2ActionPerformed
        //���� �α��� ������ ���ȭ��.   
        type="questionList";
      
        pw.println("questionList");
      
        Thread countdown = new Thread(new Runnable(){
         
            @Override
            public void run() {
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();  
                    int i =8;
                    while (flag){ //�ʱⰪ true�� ����
                     countLabel.setText(i+"��");
                     Thread.sleep(1000);
                     i--;
                     if(i<=10){
                     toolkit.beep();
                     studyPage.setBackground(Color.red);
                     }
                     if(i<0){  
                                JOptionPane.showMessageDialog(studyPage,"�н��ð� ����.", "��� �޼���",JOptionPane.WARNING_MESSAGE);
                                 card.show(mainPanel, "c4");
                                 quizTextFieldText();
                                 flag=false; //�ð��� ����ؼ� ���� â���� �Ѿ�� countdown�����带 ������
                    }  
                    }
                } catch (InterruptedException ex) {
                }
            }
            
        });
        countdown.start();
      
        //�ش� ��ư�� ������ ������� �������� �̵��Ѵ�.
        card.show(mainPanel,"card2");
    }//GEN-LAST:event_jpBtn2ActionPerformed

    private void jpBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn4ActionPerformed
        //���� ���� ��ư ������ �ش� �ؽ�Ʈ �ʵ�鿡 �Էµ� ������ �������� ���ǰ˻縦 ���ִ� �κ�.
        String[] tword = {  q1TextF.getText(),
                            q2TextF.getText(),
                            q3TextF.getText(),
                            q4TextF.getText(),
                            q5TextF.getText()
                           };
        quizResultLabelText(tword);
        
        
         //������м� ��ư �������� ȭ�� �̵���Ű�� �κ�.
    }//GEN-LAST:event_jpBtn4ActionPerformed

    private void questionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionBtnActionPerformed
       //����Ǯ�� ��ư ������ �κ�. �ش��ư�� �׳� �ð� ������ ����ȭ������ �Ѿ�Ը� ���ָ� �� �� �ʹ�.
       //�ؾ� �� �۾��� �ؽ�Ʈ ���� ������ ������ ������ִ°�.
       type="questionResultPage";
        
       quizTextFieldText();
        
        
       card.show(mainPanel,"c4");       
    }//GEN-LAST:event_questionBtnActionPerformed

    private void dayAverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayAverBtnActionPerformed
          
            type = "dAver";
            clearCanvas();
            pw.println("dAver");
         
            
           
           if(count == 0 ){
               mainThread.start();
                count++;
            } else {
                t1 = client.threadRun();
                t1.start();
           }
        
         
    }//GEN-LAST:event_dayAverBtnActionPerformed

    private void monthAverBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthAverBtnActionPerformed
        //���� ��� ������ ��� �κ�.
        type = "mAver";
        clearCanvas();
        pw.println("mAver");
        
        if(count ==0){
            mainThread.start();   //�����带 ������ �����κ��� �޾ƿ� �����͸� ����
            count++;
        } else {
            t2 = client.threadRun();
        }
            try {
                t2.sleep(500);
                t2.start();
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_monthAverBtnActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //���â���� �̵� ��ư�� �������� �̺�Ʈ �κ�.
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void idLoginTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLoginTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idLoginTextFActionPerformed

    private void pwLoginTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwLoginTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwLoginTextFActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //ȸ������ ��ư �������� �����ϴ� �κ�
        
        card.show(mainPanel,"joinCard");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void q1TextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1TextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1TextFActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         //���â���� ��躸�� �������� �̵�
        
         
        card.show(mainPanel,"averCard"); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //ȸ�����Խ� ������ �Է��ϰ� ȸ������ ��ư�� ������ �� �̺�Ʈ �߻� �޼���.
        
        type = "memberJoin";
        
        pw.println("memberJoin/"+                        //ȸ������ â���� �Է��� ������ ����ȭ ���Ѽ� ������ ������.
                joinTextField1.getText()+"/"
                +joinTextField2.getText()+"/"
                +joinTextField5.getText()+"/"
                +joinTextField6.getText());
        
        
        card.show(mainPanel,"LoginCard");
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void joinTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_joinTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_joinTextField1ActionPerformed

    private void mainMoveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainMoveBtnActionPerformed
        //�������� �̵��ϱ� ��ư
        
        card.show(mainPanel,"LoginCard");
    }//GEN-LAST:event_mainMoveBtnActionPerformed

    private void updateInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInfoBtnActionPerformed
     //ȸ�� �������� ��ư �������� ������ ��
     type = "updateInfo";
     
     pw.println("updateInfo");
     
     card.show(mainPanel,"updateCard");
     
     /////////////////////////////key��������
    }//GEN-LAST:event_updateInfoBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       ///�������� �� ������ �Է� ��ư ������ �� ���� �� 
        type = "infoUpdate";
        
        
        pw.println("infoUpdate/"+                        //ȸ������ â���� �Է��� ������ ����ȭ ���Ѽ� ������ ������.
                mUpdateLabel.getText()+"/"
                +joinTextField8.getText()+"/"
                +joinTextField11.getText()+"/"
                +joinTextField12.getText()+"/");
        
        
        card.show(mainPanel,"LoginCard");
        
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        flag = false;
        //studyPage���� testPage�� �Ѿ���Ƿ�
        // countdown ������ ����
        type = "testWords";
        pw.println(type);
        quizTextFieldText();
        //������ ������ testWords�� ����
        //alist�� ����Ǿ� �ִ� �ܾ testpage�� �ִ� ������ ���̺� �־���
        card.show(mainPanel, "card2");
    }//GEN-LAST:event_jButton8ActionPerformed
    public void setInstance(Client c){
        client = c;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     
        Client client = new Client(); 
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
    private javax.swing.JLabel LoginBeforeLa;
    private javax.swing.JLabel QLabel1;
    private javax.swing.JLabel QLabel2;
    private javax.swing.JLabel QLabel3;
    private javax.swing.JLabel QLabel4;
    private javax.swing.JLabel QLabel5;
    private javax.swing.JLabel TodayQLabel;
    private java.awt.Canvas averCanvas;
    private javax.swing.JLabel countLabel;
    private javax.swing.JLabel dQLabel_1;
    private javax.swing.JLabel dQLabel_2;
    private javax.swing.JLabel dQLabel_3;
    private javax.swing.JLabel dQLabel_4;
    private javax.swing.JButton dayAverBtn;
    private javax.swing.JTextField idLoginTextF;
    private javax.swing.JPanel infoUpdatePanel;
    private javax.swing.JLabel j;
    private javax.swing.JLabel j1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDialog jDialog3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel joinPanel;
    private javax.swing.JTextField joinTextField1;
    private javax.swing.JTextField joinTextField11;
    private javax.swing.JTextField joinTextField12;
    private javax.swing.JTextField joinTextField2;
    private javax.swing.JTextField joinTextField3;
    private javax.swing.JTextField joinTextField5;
    private javax.swing.JTextField joinTextField6;
    private javax.swing.JTextField joinTextField8;
    private javax.swing.JTextField joinTextField9;
    private javax.swing.JButton jpBtn2;
    private javax.swing.JButton jpBtn4;
    private javax.swing.JLabel mUpdateLabel;
    private javax.swing.JButton mainMoveBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton monthAverBtn;
    private javax.swing.JPasswordField pwLoginTextF;
    private javax.swing.JLabel q1Label;
    private javax.swing.JTextField q1TextF;
    private javax.swing.JLabel q2Label;
    private javax.swing.JTextField q2TextF;
    private javax.swing.JLabel q3Label;
    private javax.swing.JTextField q3TextF;
    private javax.swing.JLabel q4Label;
    private javax.swing.JTextField q4TextF;
    private javax.swing.JLabel q5Label;
    private javax.swing.JTextField q5TextF;
    private javax.swing.JPanel qExamPanel;
    private javax.swing.JPanel qExamResultPanel;
    private javax.swing.JLabel qRLabel1;
    private javax.swing.JLabel qRLabel2;
    private javax.swing.JLabel qRLabel3;
    private javax.swing.JLabel qRLabel4;
    private javax.swing.JLabel qRLabel5;
    private javax.swing.JLabel qRMeanLa;
    private javax.swing.JLabel qRMeanLa2;
    private javax.swing.JLabel qRMeanLa3;
    private javax.swing.JLabel qRMeanLa4;
    private javax.swing.JLabel qRMeanLa5;
    private javax.swing.JLabel qResult1;
    private javax.swing.JLabel qResult2;
    private javax.swing.JLabel qResult3;
    private javax.swing.JLabel qResult4;
    private javax.swing.JLabel qResult5;
    private javax.swing.JTextArea questionArea;
    private javax.swing.JButton questionBtn;
    private javax.swing.JPanel questionPanel;
    private javax.swing.JPanel studyPage;
    private javax.swing.JTextArea target;
    private javax.swing.JButton updateInfoBtn;
    private javax.swing.JPanel userPagePanel;
    // End of variables declaration//GEN-END:variables

    @Override 
    public  void run() {
         
    }
    
    
}
