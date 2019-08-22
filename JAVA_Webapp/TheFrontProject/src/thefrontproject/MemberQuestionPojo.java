/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thefrontproject;

import java.io.Serializable;

/**
 *
 * @author neo
 */
public class MemberQuestionPojo implements Serializable{
    private String id;     //유저아이디
    private String date;   //문제 맞추고 데이터 저장할때 함께 저장하는 현재 날짜
    private int wordNum;   //유저가 회원가입시 설정한 문제수(일일 출력되는 문제)
    private int dwinNum;   //유저가 맞춘 일일 문제 수(정답 수)
    private int wTotalNum; //유저가 풀이한 총 문제의 수(정답수가 아님)
    private int winNum;    //유저가 풀이한 문제의 총 정답수

    public MemberQuestionPojo(String id, String date, int wordNum, int dwinNum, int wTotalNum, int winNum) {
        this.id = id;
        this.date = date;
        this.wordNum = wordNum;
        this.dwinNum = dwinNum;
        this.wTotalNum = wTotalNum;
        this.winNum = winNum;
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getWordNum() {
        return wordNum;
    }

    public void setWordNum(int wordNum) {
        this.wordNum = wordNum;
    }

    public int getDwinNum() {
        return dwinNum;
    }

    public void setDwinNum(int dwinNum) {
        this.dwinNum = dwinNum;
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
}
