/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BeepPrintExample2 {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                Toolkit toolkit = Toolkit.getDefaultToolkit();
                for(int i=0;i<5;i++){
                    toolkit.beep();
                    try {
                        Thread.sleep(500);
                    } catch (Exception ex) {
                      
                    }
                }
            }
        };
        thread.start();
        for(int i=0; i<5; i++){
            System.out.println("¶ò");
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
               
            }
        }
  }
}
  