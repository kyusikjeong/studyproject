/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

/**
 *
 * @author KOSTA
 */
public class CarMain {
    public static void main(String[] args) {
        Car_MT cm = new Car_MT();
        Producer producer = new Producer(cm);
        Customer customer = new Customer(cm);
        
        Thread t1 = new Thread(producer,"CarMaker");
        Thread t2 = new Thread(customer,"Customer");
        
        t1.start();
        t2.start();
        
    }
}
