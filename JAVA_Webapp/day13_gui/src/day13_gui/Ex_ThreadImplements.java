/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day13_gui;

public class Ex_ThreadImplements implements Runnable{
  
    public void run(){
        for(int i = 0; i<=10; i++){
          
                System.out.println("extends i"+i);
        }
    }
}
