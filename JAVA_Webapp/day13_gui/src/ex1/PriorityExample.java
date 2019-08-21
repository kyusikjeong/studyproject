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
//스레드 우선순위 테스트를 위해서 10개를 생성 한 코드
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
