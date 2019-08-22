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
//    private String mFilePath = "C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\memberData.properties";    //�ݵ�� ���� ��� Ȯ���� ��.
//    private String qFilePath = "C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\memberDataQuiz.properties"; //ȸ���� ���� ���� Ǭ ������ ���� ��Ű�� ����.
//    private String qDataFilePath="C:\\bigdataStudy\\java\\networkspace\\TheFrontProject\\src\\thefrontproject\\quizData.properties";
    private String mFilePath = "C:\\00_GUISpace\\TheFrontProject\\src\\thefrontproject\\memberData.properties";    //�ݵ�� ���� ��� Ȯ���� ��.
    private String qFilePath = "C:\\00_GUISpace\\TheFrontProject\\src\\thefrontproject\\memberDataQuiz.properties"; //ȸ���� ���� ���� Ǭ ������ ���� ��Ű�� ����.
    private String qDataFilePath="C:\\00_GUISpace\\TheFrontProject\\src\\thefrontproject\\quizData.properties";
    private ArrayList<MemberDataPojo> memberList; 
    private ArrayList<QuizWordPojo> qList;
    private ArrayList arr; //�޼��忡�� �����Ҷ� ���� �ν��Ͻ�����
    private String userId; ///���̵� �ӽ����尪 - �α��� �������� ��

   
    private ArrayList<MemberQuestionPojo> mQuestionList;
    public FileManager(){        
         memberList = readMemberFile(); //���� �����͸� �ִ��� ���� ����ϱ� ���� �����ڸ� ����� ���� ����Ʈ�� �ѹ� �ҷ��ͼ� ���� �ϵ��� ��
         mQuestionList = readQDataFile();
         qList = readQuizDataList();
    }
    
    
    
    
    public ArrayList readMemberFile(){  //������ ��� ������ ������ ��� �з��� ���� ��̸���Ʈ�� �����Ͽ� �����Ѵ�. 
        arr = new ArrayList(); //��ü ������ �ڵ����� ����Ʈ�� �����ǰ� ��������Ƿ� ������ �ٲٷ��� �޼��� ���ĵ� �ٲ���Ѵ�.
        try {
            BufferedReader br = new BufferedReader(new FileReader(mFilePath));
            String readLine = null;
            while((readLine=br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(readLine); //���� ������ �о�ͼ� �����ڷ� �ڸ���.
                String id = st.nextToken("////");
                String pw = st.nextToken("////");
                String name = st.nextToken("////");
                String school = st.nextToken("////");
                int wordNum = Integer.parseInt(st.nextToken("////"));
                int totalNum = Integer.parseInt(st.nextToken("////"));
                int winNum = Integer.parseInt(st.nextToken("////"));
                
                arr.add(new MemberDataPojo(id,pw,name,school,wordNum,totalNum,winNum));//Pojo�� ��ü������ ���� ������ �����͸� ���� ���ų�,���� ����, �񱳵� �۾��� �����ϰ� �ϱ� �����̴�.
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
   
    public boolean idCheck(String id){  //���̵� �̹� ���ԵǾ� �ִ��� ���Ͽ��� �����͸� �� �о�ͼ� ������. 
        boolean check = true;
            
            for(MemberDataPojo m: memberList){
                if(id.equals(m.getId())){
                    System.out.println("�̹� ������ ���̵��Դϴ�.");
                    check = false;
                }
            }
        return check;
    }
    public boolean idPwCheck(String msg){  //���̵� �̹� ���ԵǾ� �ִ��� ���Ͽ��� �����͸� �� �о�ͼ� ������. 
        System.out.println("msg"+msg);    
        boolean check = false;
            StringTokenizer st = new StringTokenizer(msg);
            String gubun = st.nextToken("////");                                 //���⼭ ������ ���� ������� �����Ͱ� ��̸���Ʈ�� ����ȴٴ� ���� Ȯ���ؾ���. 
            String id = st.nextToken("////");
            String pw = st.nextToken("////");
            
            for(MemberDataPojo m: memberList){//���̵� ���ؼ� ���̵� �����ϰ� ��й�ȣ�� ��ġ�ϸ� true �����ϰ�
                if(id.equals(m.getId()) && pw.equals(m.getPw())){
                     System.out.println("�α��� ����");
                     setUserId(id);
                     check = true;
                     break;
                }else if(!id.equals(m.getId())){
                    System.out.println("���̵� Ʋ�Ƚ��ϴ�.");
                    check = false;
                } else if(id.equals(m.getId()) && !pw.equals(m.getPw())){
                    System.out.println("��й�ȣ�� Ʋ�Ƚ��ϴ�.");
                    check = false;
                
                }
                
            }
        return check;
    }
    public boolean idServerCheck(String msg){  //���̵� �̹� ���ԵǾ� �ִ��� ���Ͽ��� �����͸� �� �о�ͼ� ������. 
        boolean check = true;
            StringTokenizer st = new StringTokenizer(msg);
            String gubun = st.nextToken("////");                                 //���⼭ ������ ���� ������� �����Ͱ� ��̸���Ʈ�� ����ȴٴ� ���� Ȯ���ؾ���. 
            String id = st.nextToken("////");
            String pw = st.nextToken("////");
            String name = st.nextToken("////");
            String school = st.nextToken("////");
//            System.out.println(gubun+"test :" + id+ " , "+pw + " ,"+name+ " ,"+" ,"+school);
            for(MemberDataPojo m: memberList){
                if(id.equals(m.getId())){
                    System.out.println("�̹� ������ ���̵��Դϴ�.");
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
     public void writeMemberFile(String id,String pw,String name,String school){ //���̵� �ش��ϴ� ���� ������ ���� ���Ͽ� �����Ѵ�. ȸ�����Կ� �޼���. 
        try {
            if(idCheck(id)){  //�ش��ϴ� ���̵� ������ check �޼��忡�� true�� ���Ͻ����ֹǷ� ���� ������ ����
                    BufferedWriter bw = new BufferedWriter(new FileWriter(mFilePath,true));
                    bw.write(id+"////"+pw+"////"+name+"////"+school+"////"+5+"////"+0+"////"+0+"////");//ȸ������ ó�� �Ҷ� �� ���� Ǭ ���� �� ���� �������� 0���� �Է��Ѵ�.
                    bw.newLine();
                    bw.flush();
                    bw.close();
                }
            } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void writeMemberFile(String id,String pw,int wordNum,int totalNum,int winNum){ //���̵� �ش��ϴ� ���� ������ ���� ���Ͽ� �����Ѵ�. ȸ�����Կ� �޼���. 
        try {
            if(idCheck(id)){  //�ش��ϴ� ���̵� ������ check �޼��忡�� true�� ���Ͻ����ֹǷ� ���� ������ ����
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
                
        
        public void updateMemberFile(String msg){ //�����̴ϱ� ���̵� �ش��ϴ� ���� �־�߰���... �˻��� ���̵��� ���� ������ �ش� ������ ������Ʈ ħ
           
            StringTokenizer st = new StringTokenizer(msg);
         
                String gubun = st.nextToken("/");                                 //���⼭ ������ ���� ������� �����Ͱ� ��̸���Ʈ�� ����ȴٴ� ���� Ȯ���ؾ���. 
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
                    for(MemberDataPojo m : memberList){//���Ͽ� �ٲ� ������ �����ϱ� ���� ������ �����͸� ������ ȸ���� ��� ������ �ٽ� ���� �����. 
                                                        //����Ŭ������ ���ϴ� ������ �о �׺κи� �����ϱⰡ �ȵǰų� ��ٷο�Ƿ� �ѹ��� ������ ����� ����...
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
    
    public ArrayList readQDataFile(){  //������ ��� ������ ������ ��� �з��� ���� ��̸���Ʈ�� �����Ͽ� �����Ѵ�. 
        ArrayList arr = new ArrayList();    
        try {
            BufferedReader br = new BufferedReader(new FileReader(qFilePath));
            String readLine = null;
            while((readLine=br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(readLine);
                String id = st.nextToken("////");                                 //���⼭ ������ ���� ������� �����Ͱ� ��̸���Ʈ�� ����ȴٴ� ���� Ȯ���ؾ���. 
                String date = st.nextToken("////");
                int wordNum = Integer.parseInt(st.nextToken("////"));  
                int dayWinNum = Integer.parseInt(st.nextToken("////"));
                int wordTotalNum = Integer.parseInt(st.nextToken("////"));
                int winTotalNum = Integer.parseInt(st.nextToken("////"));
               
             arr.add(new MemberQuestionPojo(id,date,wordNum,dayWinNum,wordTotalNum,winTotalNum)); //�ڸ� �����͸� �� pojo�� ��ü������ �ű⿡ �־ ����Ʈ�� �־����� �����غ���..
         }
            br.close();
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        } catch (IOException ex) {
           ex.printStackTrace();
        }
        return arr;
    }
    public void writeQDataFile(String id,int wordNum,int dwinNum){  //������ ��� ������ ������ ��� �з��� ���� ��̸���Ʈ�� �����Ͽ� �����Ѵ�. 
        try {                                                //�ش� �޼��带 ����ϱ� ���ؼ��� ����Ǯ�� ���� ���� ȸ���� ���̵𰪰� ������ ������ ��,���� ���� ������ ���� �ʿ��ϴ�.
            BufferedWriter bw = new BufferedWriter(new FileWriter(mFilePath));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(qFilePath,true));    
                //�ش��ϴ� ���̵� Ǭ �� �������� ��� Ǯ���� �������� ��ħ. �׸��� ���� �� ������+���� ���� �������� ���ؼ� �ش� ���̵��� ���� �����(������Ʈ)
                for(MemberDataPojo m : memberList){
                    if(id.equals(m.getId())){                       //���� Ǯ�� �� �����͸� �����ϱ⿡ �ռ� ȸ�� ������ �� ���� Ǭ ���� �� ������� ������Ʈ ����� �ϹǷ� �Ʒ��� �۾��� ������
                        m.setwTotalNum(m.getwTotalNum()+wordNum);   //�ش��ϴ� ���̵��� ������ �� �о�ͼ� �κκи� �ջ��Ų��.
                        m.setWinNum(m.getWinNum()+dwinNum);         
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");  //��¥�� �����ϱ� ����. ���߿� ����Ϸ��� ������
                        Date date = new Date();                                     //SimpleDateFormat Ŭ������ ����ϱ� ���� data Ŭ����
                                                                                    //sdf.format(date) �� �ϰ� �Ǹ� ���˿� �Է��� ������ ���� ��¥�� �Էµȴ�.
//                      System.out.println(m.getId()+"////"+sdf.format(date)+"////"+m.getWordNum()+"////"+dwinNum+"////"+m.getwTotalNum()+"////"+m.getWinNum()+"////");                                                                                       
                        bw1.write(m.getId()+"////"+sdf.format(date)+"////"+m.getWordNum()+"////"+m.getwTotalNum()+"////"+m.getWinNum()+"////");
                        bw1.newLine();
                    }
                    //���Ͽ� �ٲ� ������ �����ϱ� ���� ������ �����͸� ������ ȸ���� ��� ������ �ٽ� ���� �����. ����Ŭ������ ���ϴ� ������ �о �׺κи� �����ϱⰡ �ȵǰų� ��ٷο�Ƿ� �ѹ��� ������ ����� ����...
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
