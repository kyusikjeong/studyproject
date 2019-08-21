/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day13_gui;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Ex_ThreadExtends extends Thread{
  
    @Override
    public void run(){
        for(int i = 0; i<=360; i+=10){
            System.out.println("extends T"+i);
           
        }
    }
}
