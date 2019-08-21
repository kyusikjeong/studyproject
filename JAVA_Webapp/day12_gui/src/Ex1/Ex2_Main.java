/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * 스레드는 순서가 없고, 실행되는 시점이 명확하지 않다.
 */
public class Ex2_Main {
    public static void main(String[] args) {
        Ex2_MyThread1 em  = new Ex2_MyThread1();
        em.start();
        //스레드는 생명주기가 있어서 두번 start를 호출할 수 없다.
        //em.start();
        //Runnable 인터페이스를 구현한 클래스
        
        Thread t1 = new Thread(new Ex2_Runnable1());
        t1.start();
        //메인메서드에 지연시간을 주기위해 반복
        for(int i=0; i<10; i++){
            System.out.print(i+"\t");
        }
    }
}
