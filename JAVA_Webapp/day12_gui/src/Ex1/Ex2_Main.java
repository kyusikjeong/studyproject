/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

/**
 *
 * ������� ������ ����, ����Ǵ� ������ ��Ȯ���� �ʴ�.
 */
public class Ex2_Main {
    public static void main(String[] args) {
        Ex2_MyThread1 em  = new Ex2_MyThread1();
        em.start();
        //������� �����ֱⰡ �־ �ι� start�� ȣ���� �� ����.
        //em.start();
        //Runnable �������̽��� ������ Ŭ����
        
        Thread t1 = new Thread(new Ex2_Runnable1());
        t1.start();
        //���θ޼��忡 �����ð��� �ֱ����� �ݺ�
        for(int i=0; i<10; i++){
            System.out.print(i+"\t");
        }
    }
}
