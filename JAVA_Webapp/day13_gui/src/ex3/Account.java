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
    //100,200,300의 랜덤한 값
    //동기화 처리를 수행할 수 있다.
    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void setBalance(int balance) {
        this.balance = balance;
        System.out.println("검사 :"+balance);
    }
    public synchronized void withdraw(int money){
        synchronized(this){//동기화 블럭
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
