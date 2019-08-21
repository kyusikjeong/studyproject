/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.awt.Toolkit;

/**
 *
 * @author KOSTA
 */
public class Exam_Thread extends Thread{
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for(int i=10;i>=0;i--){
            

            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }
        }
    }
}
