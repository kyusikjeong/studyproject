/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Car_MT {
    //������ �ڵ����� �����ϴ� ArrayList
    private ArrayList<String> carList;
    public Car_MT(){
        carList = new ArrayList<>();
    }
    public String getCar(){
        String carName = "";
        int carNum = (int)(Math.random()* 3);
        //�ڵ����� �����ؼ� ��ȯ ���ִ� ����!
        switch(carNum){
            case 0: carName = "���׷���1";break;
            case 1: carName = "���׷���2";break;
            case 2: carName = "���׷���3";break;
            
        }
        return carName;
    }
    
    public synchronized String pop(Thread t){
        String carName="";
        if(carList.size() == 0){
            System.out.println("����� �ڵ����� �����ϴ�.");
            System.out.println("������ �Ϸ� �� ������ ���ǿ���");
            System.out.println("Ŀ�� ���� �ϸ鼭 ��ٸ�����!");
            System.out.println("-----------------------------");
            try {
                wait();
            } catch (InterruptedException ex) {
            }
    }
        
        carName = carList.remove(carList.size() -1);
        System.out.println("�մ��� ���� �����߽��ϴ�");
        System.out.println("������ ���� ����:: ====>");
        System.out.println(carName+":"+t.getName());
        return carName;
    }
    
    public synchronized void push(String car, Thread t){
        carList.add(car);
        System.out.println("�ֹ��Ͻ� "+car+"�ڵ����� ����� �����ϴ�.");
        System.out.println("Thread : "+t.getName());
        if(carList.size() == 5){
            notify();
        }
    }
    
  
}
