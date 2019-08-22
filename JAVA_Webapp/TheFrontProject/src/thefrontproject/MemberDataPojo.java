package thefrontproject;

import java.io.Serializable;


public class MemberDataPojo implements Serializable{
    private String id,pw;  //아이디 비밀번호
    private String userId; //로그인한 유저의 아이디. 회원정보 파일의 데이터를 불러올때 사용한다.
    private String school;  
    private String name;  
    private int wordNum=5; //유저가 회원가입 시 설정한 일일 문제풀이 갯수
    private int wTotalNum=0;// wordTotalNumber. 유저가 풀이한 문제의 총 갯수
    private int winNum=0; //유저가 맞춘 문제의 총 갯수
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
