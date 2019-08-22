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
    private String id;     //�������̵�
    private String date;   //���� ���߰� ������ �����Ҷ� �Բ� �����ϴ� ���� ��¥
    private int wordNum;   //������ ȸ�����Խ� ������ ������(���� ��µǴ� ����)
    private int dwinNum;   //������ ���� ���� ���� ��(���� ��)
    private int wTotalNum; //������ Ǯ���� �� ������ ��(������� �ƴ�)
    private int winNum;    //������ Ǯ���� ������ �� �����

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
