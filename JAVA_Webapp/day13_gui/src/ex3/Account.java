/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Account {
    private int balance; 
    //100,200,300�� ������ ��
    //����ȭ ó���� ������ �� �ִ�.
    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
        System.out.println("�˻� :"+balance);
    }
    public synchronized void withdraw(int money){
        synchronized(this){//����ȭ ��
        if(balance >= money){
            try {
                Thread.sleep(1000);
                balance -= money;
            } catch (InterruptedException ex) {
              ex.printStackTrace();
            }
        } 
   }
    }
   
    
}
