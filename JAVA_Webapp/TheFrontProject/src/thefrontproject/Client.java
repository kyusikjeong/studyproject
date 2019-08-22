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
    
    private MemberDataPojo mdata; //회원정보 Pojo
    private Socket s;         //통신을 담당하는 소켓
    private PrintWriter pw;   //데이터 보낼때 쓰는 프린터 롸이트
    
    
    private int menuNum=0; //이 번호는 스레드에게 시키는 일을 구분시키기 위해 사용한다. 버튼 누를 시 번호를 바꾸면서 조건문으로 하도록...일단 이렇게만 만들자.
    int totalNum,wordNum,winNum;      //회원의 푼 문제 총 수, 가입시 설정한 일일 출력되는 단어 수, 맞춘 총 문제수
    int x=0;     //그래프 좌표
    int y=0;     //좌표
    int width=0;   //너비
    int height=0;  //높이
    int arcAngle=0;        //그래프에서 원 그릴때 채워지는 각도. 360 이면 꽉차는 형식.
    private String str="";  //그래프 문자열. 캔버스에 그려지는 그래프 옆의 % 숫자
    private String type;   //작업할 시 조건문에 사용하기 위한 변수. 
    private Client client;  
    private Thread t1,t2;  //그림 그릴때 쓰는 쓰레드.
   
    
    private Graphics g;      
    private Thread mainThread;  //통신 담당을 위해 사용한 스레드.
    private int count=0;    //메인스레드를 한번만 돌리기 위한 카운트변수. 두번 돌리면 에러나기에 한번만 돌림
    private ObjectInputStream ois;   //메인스레드에서 객체를 보내기 때문에 오브젝트 스트림을 사용함
    
    private Object tobject;  //메인스레드에서 전달받은 오브젝트를 받기 위한 변수
    private Vector v;        //일간 평균 5개를 구한값을 서버를 통해 전달받은 벡터변수
    private boolean flag = true;
    /**
     * Creates new form Client
     */
    public Client() {
        initComponents();
        card = (CardLayout)mainPanel.getLayout();
        // card.show(mainPanel,"averCard");  //개인파트 시연을 위해 여기서 시작
        card.show(mainPanel,"LoginCard");
        
        
        g = averCanvas.getGraphics();
        try {
            s = new Socket("localhost",9998);     //접속할 대상의 ip 주소 및 포트번호
            pw = new PrintWriter(s.getOutputStream(),true);  //소켓 객체 안의 outputstream을 가져와서 출력하게 됨.
            ois = new ObjectInputStream(s.getInputStream());
            mainThread=new Thread(){
          @Override
          public void run(){ /////////////////////////////////////////////////////////////////////////////////////////////////@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@/상단스레드
               try {
                    while(true){
                      tobject = (Object)ois.readObject();  //서버로부터 받은 오브젝트 요소. 
                      if (type.equals("dAver")){
                          v = new Vector();               
                          v =(Vector)tobject;           // 가변배열을 사용하고, 배열의 맨 끝값을 먼저 출력해주려고 벡터를 사용해 보았다.
                          qDayLabelSetText();           //이 메소드를 실행해서 상단에 최근 5회간의 평균을
                                                        // 출력하고 중앙에 그래프를 그린다.
                      } else if (type.equals("mAver")){
                        qMonthLabelSetText(Integer.parseInt(tobject.toString())); //월간 평균 그래프
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
       
        Thread thread = new Thread(client){  //스레드 클래스로부터 직접 생성하는 방법중 하나. page 579
                                           //현재 이 클래스는 Runnable 인터페이스를 구현한 클래스이고, main메서드에서 해당 객체를 생성했으므로
                                           // 이 인스턴스를 가리키는 this를 전달해주면 스레드 클래스에서 Runnable 을 매개값으로 갖는 생성자를 호출하여 스레드를 사용할 수 있게된다. 
            //g.fillArc(350,80,200, 200, 80, arcAngle);
            public void run(){
                if (type.equals("dAver")){
                    qDayLabelSetText();
                 } else if (type.equals("mAver")){
                    qMonthLabelSetText(Integer.parseInt(tobject.toString()));   //서버로부터 월간 평균값을 오브젝트 타입으로 받아와서, 변환하여 메소드실행
                 }
            }
        };
        return thread;                  //위에서 이 작업을 하는 메소드를 가지고 있는 객체의 주소를 가지고 있는 thread 참조변수를 리턴. 
                                        //스레드 객체는 메소드가 실행될때마다 새로 생성되므로 독립된 스레드들을 사용할 수 있다.
    }
    
    ////////////////////////////////////Method line/////////////////////////////////////////////////////////////// /////////////////// /////////////////// /////////////////// ///////////////////  
    public void qDayLabelSetText(){  //상단에 있는 라벨에 일간 평균 값들을 출력해주기 위한 메서드
        int idx = 1;   //가장 최근 데이터가 마지막에 저장되기 때문에, 라벨에 배열에 마지막 인덱스 값을 빼기 위해 일단 변수 선언    
        int vsize = (v.size()<5? v.size(): 5);  //일간 데이터가 5개까지 출력되므로, 뽑아온 데이터가 5개 이상이면 5를, 그 미만이면 벡터 사이즈를 가지는 변수선언
        //용도는 아래에서 데이터 들어온 수 만큼 평균을 구하는 반복문을 돌리기 위함.
        TodayQLabel.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0) +"%")); idx++;   //벡터 사이즈 -1이 벡터 끝 인덱스이므로 끝 인덱스면 해당값 저장하고 아니면 0을 저장
        dQLabel_1.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;     //그 뒤 인덱스를 증가시켜서 1씩 추가로 감소하게 함
        dQLabel_2.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;
        dQLabel_3.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); idx++;
        dQLabel_4.setText(String.valueOf(v.get(v.size()-idx >=0 ?v.size()-idx : 0)+"%")); 
        
        QLabel1.setText("Today :");  //해당 라벨들은 평균값 앞의 안내 라벨들.
        QLabel2.setText("Today-1:");
        QLabel3.setText("Today-2");
        QLabel4.setText("Today-3");
        QLabel5.setText("Today-4");
        idx = 1;
        int average=0;
        
        for(;idx<= vsize;idx++){ //벡터의 사이즈만큼 반복하게 하고 안의 모든 데이터를 더해서 평균을 구함.
            average += Integer.parseInt(v.get(v.size()-idx >=0 ?v.size()-idx : 0).toString());  
                //벡터 안에 들어있는 값을 다 꺼내면서 더하여 평균값을 구하는데,  벡터의 인덱스를 구할때 삼항 연산자를 사용하여
                //앞의 값이 0보다크면 계속 감소시키면서 값을 뽑고, 0이되면 0번슬롯의 값을 꺼내면서 끝낸다.
        }
        drawArc(average/vsize);   //벡터 사이즈로 평균을 나눈수를 원을 그리는 메서드
    }
    
    public void qMonthLabelSetText(int average){ //상단에 월간 평균 데이터를 출력해주기 위한 메서드
        TodayQLabel.setText("_____");
        dQLabel_1.setText("_____");
        dQLabel_2.setText(String.valueOf(average)+"%");
        dQLabel_3.setText("_____");
        dQLabel_4.setText("_____");
        QLabel1.setText("______");
        QLabel2.setText("______");
        QLabel3.setText("---월간 평균---");
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
    public void drawArc(int average){       //값을 증가시키면서 
        int num =  (int) (average * 3.6);    //평균값 구하는 부분. 매개변수로 필요한 값을 전달받도록 수정해야 한다.
        str = String.valueOf(average+"%");
        
        for(; arcAngle<=num; arcAngle+=10){
       // System.out.println("height :"+height);
            try {
                
                 averCanvas.repaint();
                 Thread.sleep(50);
                 //Canvas 의 repaint() -> update() -> paint()
            } catch (InterruptedException ex) {
            }
        }
        arcAngle = 0;
    }
    
    public void clearCanvas(){  //캔버스를 비워줌
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
    
        qRLabel1.setText(list.get(0).getWord());  //단어 셋팅
        qRLabel2.setText(list.get(1).getWord());
        qRLabel3.setText(list.get(2).getWord());
        qRLabel4.setText(list.get(3).getWord());
        qRLabel5.setText(list.get(4).getWord());
        
        qRMeanLa.setText(list.get(0).getMean());  //뜻 셋팅
        qRMeanLa2.setText(list.get(1).getMean());
        qRMeanLa3.setText(list.get(2).getMean());
        qRMeanLa4.setText(list.get(3).getMean());
        qRMeanLa5.setText(list.get(4).getMean());
        
        qResult1.setText(list.get(0).getMean().equals(tword[0]) ? "정답입니다.": "오답입니다.");
        qResult2.setText(list.get(1).getMean().equals(tword[1]) ? "정답입니다.": "오답입니다.");
        qResult3.setText(list.get(2).getMean().equals(tword[2]) ? "정답입니다.": "오답입니다.");
        qResult4.setText(list.get(3).getMean().equals(tword[3]) ? "정답입니다.": "오답입니다.");
        qResult5.setText(list.get(4).getMean().equals(tword[4]) ? "정답입니다.": "오답입니다.");
        
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

        jLabel4.setText("분석/average");

        mainMoveBtn.setBackground(new java.awt.Color(255, 255, 153));
        mainMoveBtn.setText("메인으로");
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
        monthAverBtn.setText("월간평균");
        monthAverBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthAverBtnActionPerformed(evt);
            }
        });

        dayAverBtn.setBackground(new java.awt.Color(255, 255, 153));
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
        jLabel5.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
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

        LoginBeforeLa.setText("로그인 성공");

        jpBtn2.setText("문제풀기");
        jpBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn2ActionPerformed(evt);
            }
        });

        updateInfoBtn.setText("정보수정");
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

        jLabel1.setText("panel3-문제푸는화면");

        questionBtn.setText("문제풀기");
        questionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionBtnActionPerformed(evt);
            }
        });

        questionArea.setColumns(20);
        questionArea.setFont(new java.awt.Font("휴먼매직체", 1, 24)); // NOI18N
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

        jLabel3.setText("result - 정답/오답");

        jpBtn4.setText("문제제출");
        jpBtn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jpBtn4ActionPerformed(evt);
            }
        });

        q1Label.setText("문제1");

        q2Label.setText("문제2");

        q3Label.setText("문제3");

        q1TextF.setPreferredSize(new java.awt.Dimension(67, 30));
        q1TextF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                q1TextFActionPerformed(evt);
            }
        });

        q2TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        q3TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        q4Label.setText("문제4");

        q5Label.setText("문제5");

        q4TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        q5TextF.setPreferredSize(new java.awt.Dimension(67, 30));

        jButton3.setText("평균보기");
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

        jLabel6.setFont(new java.awt.Font("굴림", 1, 18)); // NOI18N
        jLabel6.setText("Y o u r      R e s u l t");

        jButton4.setText("통계보기");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("다시하기");

        jPanel2.setBackground(new java.awt.Color(0, 102, 51));

        qRLabel1.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRLabel1.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel1.setText("jLabel10");

        qRLabel2.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRLabel2.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel2.setText("jLabel11");

        qRLabel3.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRLabel3.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel3.setText("jLabel12");

        qRLabel4.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRLabel4.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel4.setText("jLabel13");

        qRLabel5.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRLabel5.setForeground(new java.awt.Color(255, 255, 255));
        qRLabel5.setText("jLabel14");

        qRMeanLa4.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRMeanLa4.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa4.setText("jLabel18");

        qRMeanLa5.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRMeanLa5.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa5.setText("jLabel19");

        qRMeanLa3.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRMeanLa3.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa3.setText("jLabel17");

        qRMeanLa2.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRMeanLa2.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa2.setText("jLabel16");

        qRMeanLa.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qRMeanLa.setForeground(new java.awt.Color(255, 255, 255));
        qRMeanLa.setText("jLabel15");

        qResult1.setBackground(new java.awt.Color(255, 255, 255));
        qResult1.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qResult1.setForeground(new java.awt.Color(255, 255, 255));
        qResult1.setText("jLabel20");

        qResult2.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qResult2.setForeground(new java.awt.Color(255, 255, 255));
        qResult2.setText("jLabel21");

        qResult3.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qResult3.setForeground(new java.awt.Color(255, 255, 255));
        qResult3.setText("jLabel22");

        qResult4.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        qResult4.setForeground(new java.awt.Color(255, 255, 255));
        qResult4.setText("jLabel23");

        qResult5.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
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

        j.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        j.setForeground(new java.awt.Color(255, 255, 255));
        j.setText("I        D");
        j.setMaximumSize(new java.awt.Dimension(45, 20));
        j.setMinimumSize(new java.awt.Dimension(45, 20));
        j.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel11.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("비밀번호");
        jLabel11.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel11.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel11.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel13.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("이름");
        jLabel13.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel13.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel13.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel14.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("출신초등학교");
        jLabel14.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel14.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel14.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel15.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("비밀번호확인");

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

        jButton6.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jButton6.setText("회원가입");
        jButton6.setActionCommand("입      력");
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

        j1.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        j1.setForeground(new java.awt.Color(255, 255, 255));
        j1.setText("I        D");
        j1.setMaximumSize(new java.awt.Dimension(45, 20));
        j1.setMinimumSize(new java.awt.Dimension(45, 20));
        j1.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel16.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("비밀번호");
        jLabel16.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel16.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel16.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel18.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("이름");
        jLabel18.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel18.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel18.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel19.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("출신초등학교");
        jLabel19.setMaximumSize(new java.awt.Dimension(45, 20));
        jLabel19.setMinimumSize(new java.awt.Dimension(45, 20));
        jLabel19.setPreferredSize(new java.awt.Dimension(45, 20));

        jLabel20.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("비밀번호확인");

        mUpdateLabel.setFont(new java.awt.Font("굴림", 1, 12)); // NOI18N
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

        jButton7.setFont(new java.awt.Font("굴림", 1, 14)); // NOI18N
        jButton7.setText("정보수정");
        jButton7.setActionCommand("입      력");
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

        jLabel10.setText("남은시간 : ");

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
          //  card.show(mainPanel,"averCard");  //수정해야함
          // 로그인 버튼 눌렀을 시 동작
          type ="Login";
        
          pw.println("Login"+"/"+idLoginTextF.getText()+"/"+pwLoginTextF.getText());
          
          if(count ==0){
            mainThread.start();   //스레드를 돌려서 서버로부터 받아온 데이터를 돌림
            count++;
          }
            
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jpBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn2ActionPerformed
        //유저 로그인 성공시 대기화면.   
        type="questionList";
      
        pw.println("questionList");
      
        Thread countdown = new Thread(new Runnable(){
         
            @Override
            public void run() {
                try {
                    Toolkit toolkit = Toolkit.getDefaultToolkit();  
                    int i =8;
                    while (flag){ //초기값 true인 상태
                     countLabel.setText(i+"초");
                     Thread.sleep(1000);
                     i--;
                     if(i<=10){
                     toolkit.beep();
                     studyPage.setBackground(Color.red);
                     }
                     if(i<0){  
                                JOptionPane.showMessageDialog(studyPage,"학습시간 종료.", "경고 메세지",JOptionPane.WARNING_MESSAGE);
                                 card.show(mainPanel, "c4");
                                 quizTextFieldText();
                                 flag=false; //시간이 경과해서 다음 창으로 넘어가면 countdown스레드를 정지함
                    }  
                    }
                } catch (InterruptedException ex) {
                }
            }
            
        });
        countdown.start();
      
        //해당 버튼을 누르면 문제출력 페이지로 이동한다.
        card.show(mainPanel,"card2");
    }//GEN-LAST:event_jpBtn2ActionPerformed

    private void jpBtn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jpBtn4ActionPerformed
        //문제 제출 버튼 눌러서 해당 텍스트 필드들에 입력된 값들이 정답인지 조건검사를 해주는 부분.
        String[] tword = {  q1TextF.getText(),
                            q2TextF.getText(),
                            q3TextF.getText(),
                            q4TextF.getText(),
                            q5TextF.getText()
                           };
        quizResultLabelText(tword);
        
        
         //정답률분석 버튼 눌렀을시 화면 이동시키는 부분.
    }//GEN-LAST:event_jpBtn4ActionPerformed

    private void questionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionBtnActionPerformed
       //문제풀기 버튼 페이지 부분. 해당버튼은 그냥 시간 지나면 다음화면으로 넘어가게만 해주면 될 듯 싶다.
       //해야 할 작업은 텍스트 에어리어에 정해진 문제를 출력해주는것.
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
        //월간 평균 데이터 출력 부분.
        type = "mAver";
        clearCanvas();
        pw.println("mAver");
        
        if(count ==0){
            mainThread.start();   //스레드를 돌려서 서버로부터 받아온 데이터를 돌림
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
        //통계창으로 이동 버튼을 눌렀을시 이벤트 부분.
        
        
        
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void idLoginTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idLoginTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idLoginTextFActionPerformed

    private void pwLoginTextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwLoginTextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwLoginTextFActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //회원가입 버튼 눌렀을시 동작하는 부분
        
        card.show(mainPanel,"joinCard");
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void q1TextFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_q1TextFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_q1TextFActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         //결과창에서 통계보기 페이지로 이동
        
         
        card.show(mainPanel,"averCard"); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //회원가입시 정보를 입력하고 회원가입 버튼을 눌렀을 시 이벤트 발생 메서드.
        
        type = "memberJoin";
        
        pw.println("memberJoin/"+                        //회원가입 창에서 입력한 값들을 패턴화 시켜서 서버로 전송함.
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
        //메인으로 이동하기 버튼
        
        card.show(mainPanel,"LoginCard");
    }//GEN-LAST:event_mainMoveBtnActionPerformed

    private void updateInfoBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInfoBtnActionPerformed
     //회원 정보수정 버튼 눌렀을시 들어오는 곳
     type = "updateInfo";
     
     pw.println("updateInfo");
     
     card.show(mainPanel,"updateCard");
     
     /////////////////////////////key정보수정
    }//GEN-LAST:event_updateInfoBtnActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       ///정보수정 다 끝나고 입력 버튼 눌렀을 시 오는 곳 
        type = "infoUpdate";
        
        
        pw.println("infoUpdate/"+                        //회원가입 창에서 입력한 값들을 패턴화 시켜서 서버로 전송함.
                mUpdateLabel.getText()+"/"
                +joinTextField8.getText()+"/"
                +joinTextField11.getText()+"/"
                +joinTextField12.getText()+"/");
        
        
        card.show(mainPanel,"LoginCard");
        
        
        
        
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        flag = false;
        //studyPage에서 testPage로 넘어갔으므로
        // countdown 스레드 멈춤
        type = "testWords";
        pw.println(type);
        quizTextFieldText();
        //서버로 구분자 testWords를 보냄
        //alist에 저장되어 있는 단어를 testpage에 있는 각각의 레이블에 넣어줌
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
