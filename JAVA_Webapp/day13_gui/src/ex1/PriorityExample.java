/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author KOSTA
 */
public class PriorityExample {
//������ �켱���� �׽�Ʈ�� ���ؼ� 10���� ���� �� �ڵ�
    public static void main(String[] args) {
        
        for(int i=1; i<= 10; i++){
           
            Thread thread = new CalcThread("Thread"+i);
           
            if(i != 10){
                thread.setPriority(Thread.MIN_PRIORITY);
               
            } else {
                thread.setPriority(Thread.MAX_PRIORITY);
               
            }
            thread.start();
        }
    }
}
