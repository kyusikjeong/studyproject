package thefrontproject;

import java.io.Serializable;


public class MemberDataPojo implements Serializable{
    private String id,pw;  //���̵� ��й�ȣ
    private String userId; //�α����� ������ ���̵�. ȸ������ ������ �����͸� �ҷ��ö� ����Ѵ�.
    private String school;  
    private String name;  
    private int wordNum=5; //������ ȸ������ �� ������ ���� ����Ǯ�� ����
    private int wTotalNum=0;// wordTotalNumber. ������ Ǯ���� ������ �� ����
    private int winNum=0; //������ ���� ������ �� ����
    private MemberDataPojo mData;

    public MemberDataPojo(){
      
    }

    public MemberDataPojo(String id, String pw, String name,String school,int wordNum, int wTotalNum,int winNum) {
        this.id = id;
        this.pw = pw;
        this.school = school;
        this.name = name;
        this.wordNum = wordNum;
        this.wTotalNum = wTotalNum;
        this.winNum = winNum;
        
                
    }
    
    public MemberDataPojo(String id, String pw, String name,String school,int wordNum, int wTotalNum){
        this.id = id;
        this.pw = pw;
        this.school = school;
        this.name = name;
        this.wordNum = wordNum;
        this.wTotalNum = wTotalNum;
        
    }
    
    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public int getWordNum() {
        return wordNum;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
    }

    public int getwTotalNum() {
        return wTotalNum;
    }

    public void setwTotalNum(int wTotalNum) {
        this.wTotalNum = wTotalNum;
    }
      public int getWinNum() {
        return winNum;
    }

    public void setWinNum(int winNum) {
        this.winNum = winNum;
    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    public MemberDataPojo getmData() {
        return mData;
    }

    public void setmData(MemberDataPojo mData) {
        this.mData = mData;
    }
}
