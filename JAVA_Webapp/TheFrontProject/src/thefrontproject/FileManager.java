package thefrontproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileManager implements Serializable{
//    private String mFilePath = "C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\memberData.properties";    //반드시 파일 경로 확인할 것.
//    private String qFilePath = "C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\memberDataQuiz.properties"; //회원의 일일 문제 푼 데이터 누적 시키는 파일.
//    private String qDataFilePath="C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\quizData.properties";
    private String mFilePath = "C:\\00_GUISpace\\TheFrontProject\\src\\thefrontproject\\memberData.properties";    //반드시 파일 경로 확인할 것.
    private String qFilePath = "C:\\00_GUISpace\\TheFrontProject\\src\\thefrontproject\\memberDataQuiz.properties"; //회원의 일일 문제 푼 데이터 누적 시키는 파일.
    private String qDataFilePath="C:\\00_GUISpace\\TheFrontProject\\src\\thefrontproject\\quizData.properties";
    private ArrayList<MemberDataPojo> memberList; 
    private ArrayList<QuizWordPojo> qList;
    private ArrayList arr; //메서드에서 리턴할때 쓰는 인스턴스변수
    private String userId; ///아이디 임시저장값 - 로그인 성공했을 시

   
    private ArrayList<MemberQuestionPojo> mQuestionList;
    public FileManager(){        
         memberList = readMemberFile(); //파일 데이터를 최대한 적게 출력하기 위해 생성자를 실행시 파일 리스트를 한번 불러와서 재사용 하도록 함
         mQuestionList = readQDataFile();
         qList = readQuizDataList();
    }
    
    
    
    
    public ArrayList readMemberFile(){  //파일의 모든 내용을 설정한 대로 분류한 다음 어레이리스트에 저장하여 리턴한다. 
        arr = new ArrayList(); //객체 생성시 자동으로 리스트가 생성되게 만들었으므로 구조를 바꾸려면 메서드 형식도 바꿔야한다.
        try {
            BufferedReader br = new BufferedReader(new FileReader(mFilePath));
            String readLine = null;
            while((readLine=br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(readLine); //파일 내용을 읽어와수 구분자로 자른다.
                String id = st.nextToken("////");
                String pw = st.nextToken("////");
                String name = st.nextToken("////");
                String school = st.nextToken("////");
                int wordNum = Integer.parseInt(st.nextToken("////"));
                int totalNum = Integer.parseInt(st.nextToken("////"));
                int winNum = Integer.parseInt(st.nextToken("////"));
                
                arr.add(new MemberDataPojo(id,pw,name,school,wordNum,totalNum,winNum));//Pojo에 객체생성후 넣은 이유는 데이터를 꺼내 쓰거나,수정 삭제, 비교등 작업에 용이하게 하기 위함이다.
//              System.out.println("test :" + id+ " , "+pw + " ,"+wordNum+ " ,"+
//                                    totalNum+ " ,"+winNum);
            }
            
             br.close();
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        return arr;
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
    public boolean idCheck(String id){  //아이디가 이미 가입되어 있는지 파일에서 데이터를 다 읽어와서 비교해줌. 
        boolean check = true;
            
            for(MemberDataPojo m: memberList){
                if(id.equals(m.getId())){
                    System.out.println("이미 가입한 아이디입니다.");
                    check = false;
                }
            }
        return check;
    }
    public boolean idPwCheck(String msg){  //아이디가 이미 가입되어 있는지 파일에서 데이터를 다 읽어와서 비교해줌. 
        System.out.println("msg"+msg);    
        boolean check = false;
            StringTokenizer st = new StringTokenizer(msg);
            String gubun = st.nextToken("////");                                 //여기서 설정한 값의 순서대로 데이터가 어레이리스트에 저장된다는 것을 확인해야함. 
            String id = st.nextToken("////");
            String pw = st.nextToken("////");
            
            for(MemberDataPojo m: memberList){//아이디 비교해서 아이디가 존재하고 비밀번호가 일치하면 true 리턴하게
                if(id.equals(m.getId()) && pw.equals(m.getPw())){
                     System.out.println("로그인 성공");
                     setUserId(id);
                     check = true;
                     break;
                }else if(!id.equals(m.getId())){
                    System.out.println("아이디가 틀렸습니다.");
                    check = false;
                } else if(id.equals(m.getId()) && !pw.equals(m.getPw())){
                    System.out.println("비밀번호가 틀렸습니다.");
                    check = false;
                
                }
                
            }
        return check;
    }
    public boolean idServerCheck(String msg){  //아이디가 이미 가입되어 있는지 파일에서 데이터를 다 읽어와서 비교해줌. 
        boolean check = true;
            StringTokenizer st = new StringTokenizer(msg);
            String gubun = st.nextToken("////");                                 //여기서 설정한 값의 순서대로 데이터가 어레이리스트에 저장된다는 것을 확인해야함. 
            String id = st.nextToken("////");
            String pw = st.nextToken("////");
            String name = st.nextToken("////");
            String school = st.nextToken("////");
//            System.out.println(gubun+"test :" + id+ " , "+pw + " ,"+name+ " ,"+" ,"+school);
            for(MemberDataPojo m: memberList){
                if(id.equals(m.getId())){
                    System.out.println("이미 가입한 아이디입니다.");
                    check = false;
                }  
            }
            if(check == true){
               writeMemberFile(id,pw,name,school);
            }
        return check;
    }

    
    
//    public static void main(String[] args) {
//        FileManager fm = new FileManager();
//        ArrayList<MemberDataPojo> mlist = fm.readMemberFile();
//        
//        fm.updateMemberFile("infoUpdate/test1/asdf1/name1asdf/schoolasdf/");
//        
//        
//        
//    }
     public void writeMemberFile(String id,String pw,String name,String school){ //아이디에 해당하는 값이 없으면 값을 파일에 저장한다. 회원가입용 메서드. 
        try {
            if(idCheck(id)){  //해당하는 아이디가 없으면 check 메서드에서 true를 리턴시켜주므로 조건 안으로 진입
                    BufferedWriter bw = new BufferedWriter(new FileWriter(mFilePath,true));
                    bw.write(id+"////"+pw+"////"+name+"////"+school+"////"+5+"////"+0+"////"+0+"////");//회원가입 처음 할때 총 문제 푼 수와 총 맞춘 문제수를 0으로 입력한다.
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void writeMemberFile(String id,String pw,int wordNum,int totalNum,int winNum){ //아이디에 해당하는 값이 없으면 값을 파일에 저장한다. 회원가입용 메서드. 
        try {
            if(idCheck(id)){  //해당하는 아이디가 없으면 check 메서드에서 true를 리턴시켜주므로 조건 안으로 진입
                    BufferedWriter bw = new BufferedWriter(new FileWriter(mFilePath,true));
                    bw.write(id+"////"+pw+"////"+wordNum+"////"+totalNum+"////"+winNum+"////");
                    bw.newLine();
                    bw.flush();             
                    bw.close();
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
                
        
        public void updateMemberFile(String msg){ //수정이니까 아이디에 해당하는 값이 있어야겠지... 검색한 아이디의 값이 있으면 해당 정보를 업데이트 침
           
            StringTokenizer st = new StringTokenizer(msg);
         
                String gubun = st.nextToken("/");                                 //여기서 설정한 값의 순서대로 데이터가 어레이리스트에 저장된다는 것을 확인해야함. 
                String id = st.nextToken("/");
                String pw = st.nextToken("/");
                String name = st.nextToken("/");
                String school = st.nextToken("/");
                
                for(MemberDataPojo m : memberList){
                    if(id.equals(m.getId())){
                        m.setPw(pw);
                        m.setName(name);
                        m.setSchool(school);
                    }
                }
            try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(mFilePath));
                    for(MemberDataPojo m : memberList){//파일에 바뀐 정보를 저장하기 위해 수정한 데이터를 포함한 회원의 모든 정보를 다시 전부 덮어씌움. 
                                                        //파일클래스는 원하는 정보만 읽어서 그부분만 수정하기가 안되거나 까다로우므로 한번에 덮어씌우는 방식을 선택...
                        bw.write(m.getId()+"////"+m.getPw()+"////"+m.getName()
                                +"////"+m.getSchool()+"////"+m.getWordNum()+"////"+m.getwTotalNum()+"////"+m.getWinNum());
                        bw.newLine();
                    }
                    bw.flush();             
                    bw.close();
                 } catch (IOException ex) {
                    ex.printStackTrace();
                 }
        } 
    
    public ArrayList readQDataFile(){  //파일의 모든 내용을 설정한 대로 분류한 다음 어레이리스트에 저장하여 리턴한다. 
        ArrayList arr = new ArrayList();    
        try {
            BufferedReader br = new BufferedReader(new FileReader(qFilePath));
            String readLine = null;
            while((readLine=br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(readLine);
                String id = st.nextToken("////");                                 //여기서 설정한 값의 순서대로 데이터가 어레이리스트에 저장된다는 것을 확인해야함. 
                String date = st.nextToken("////");
                int wordNum = Integer.parseInt(st.nextToken("////"));  
                int dayWinNum = Integer.parseInt(st.nextToken("////"));
                int wordTotalNum = Integer.parseInt(st.nextToken("////"));
                int winTotalNum = Integer.parseInt(st.nextToken("////"));
               
             arr.add(new MemberQuestionPojo(id,date,wordNum,dayWinNum,wordTotalNum,winTotalNum)); //자른 데이터를 왜 pojo를 객체생성후 거기에 넣어서 리스트에 넣었는지 생각해보자..
         }
            br.close();
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        return arr;
    }
    public void writeQDataFile(String id,int wordNum,int dwinNum){  //파일의 모든 내용을 설정한 대로 분류한 다음 어레이리스트에 저장하여 리턴한다. 
        try {                                                //해당 메서드를 사용하기 위해서는 문제풀기 전에 현재 회원의 아이디값과 설정한 문제의 수,금일 맞춘 문제의 수가 필요하다.
            BufferedWriter bw = new BufferedWriter(new FileWriter(mFilePath));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(qFilePath,true));    
                //해당하는 아이디가 푼 총 문제수와 방금 풀이한 문제수를 합침. 그리고 맞춘 총 문제수+오늘 맞춘 문제수도 더해서 해당 아이디의 값에 덮어씌움(업데이트)
                for(MemberDataPojo m : memberList){
                    if(id.equals(m.getId())){                       //문제 풀고 그 데이터를 저장하기에 앞서 회원 정보에 총 문제 푼 수와 총 정답수를 업데이트 해줘야 하므로 아래의 작업을 진행함
                        m.setwTotalNum(m.getwTotalNum()+wordNum);   //해당하는 아이디의 정보를 다 읽어와서 두부분만 합산시킨다.
                        m.setWinNum(m.getWinNum()+dwinNum);         
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");  //날짜를 저장하기 위해. 나중에 사용하려고 저장함
                        Date date = new Date();                                     //SimpleDateFormat 클래스를 사용하기 위한 data 클래스
                                                                                    //sdf.format(date) 을 하게 되면 포맷에 입력한 형식의 현재 날짜가 입력된다.
//                      System.out.println(m.getId()+"////"+sdf.format(date)+"////"+m.getWordNum()+"////"+dwinNum+"////"+m.getwTotalNum()+"////"+m.getWinNum()+"////");                                                                                       
                        bw1.write(m.getId()+"////"+sdf.format(date)+"////"+m.getWordNum()+"////"+m.getwTotalNum()+"////"+m.getWinNum()+"////");
                        bw1.newLine();
                    }
                    //파일에 바뀐 정보를 저장하기 위해 수정한 데이터를 포함한 회원의 모든 정보를 다시 전부 덮어씌움. 파일클래스는 원하는 정보만 읽어서 그부분만 수정하기가 안되거나 까다로우므로 한번에 덮어씌우는 방식을 선택...
                    bw.write(m.getId()+"////"+m.getPw()+"////"+m.getWordNum()+"////"+m.getwTotalNum()+"////"+m.getWinNum()+"////");
                    bw.newLine();
                }
                bw.flush();
                bw1.flush();
                bw.close();
                bw1.close();
            } catch (IOException ex) {
            }
    }
    
    public ArrayList readQuizDataList(){
        arr = new ArrayList();
       
        try {
            BufferedReader br = new BufferedReader(new FileReader(qDataFilePath));
            String readLine = null;
            while((readLine=br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(readLine);
                String word = st.nextToken("=");
                String mean = st.nextToken("=");
                arr.add(new QuizWordPojo(word,mean));
            }
            br.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        return arr;
    }
    
    public ArrayList<MemberDataPojo> mSearchList(String id){
        arr = new ArrayList();
        for(MemberDataPojo mq : memberList){
             if(id.equals(mq.getId())){
                
//                  System.out.println("test :" + mq.getId()+ " , "+mq.getDate() + " ,"+mq.getWordNum()+ " ,"+
//                                  mq.getDwinNum()+ " ,"+mq.getwTotalNum()+" , "+mq.getWinNum());
                  arr.add(new MemberDataPojo(mq.getId(), mq.getPw(), mq.getName(), mq.getSchool(), mq.getwTotalNum(), mq.getWinNum()));
             }
         } 
        return arr;
    }
    
    
     public ArrayList<MemberDataPojo> getMemberList() {
        return memberList;
    }

    public ArrayList<MemberQuestionPojo> getmQuestionList() {
        return mQuestionList;
    }
     public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
   
  
    
}
