/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefrontproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class MemberData implements Serializable{
    private String id,pw;  //���̵� ��й�ȣ
    private String userId; //�α����� ������ ���̵�. ȸ������ ������ �����͸� �ҷ��ö� ����Ѵ�.

    
    private int wordNum; //������ ȸ������ �� ������ ���� ����Ǯ�� ����
    private int wTotalNum;// wordTotalNumber. ������ Ǯ���� ������ �� ����
    private int winNum; //������ ���� ������ �� ����
    private MemberData mData;

    
 
    public MemberData(){
      
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
    public MemberData getmData() {
        return mData;
    }

    public void setmData(MemberData mData) {
        this.mData = mData;
    }
}
