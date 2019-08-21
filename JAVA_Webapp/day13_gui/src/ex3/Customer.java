
package ex3;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Customer implements Runnable{
    private Car_MT car;
    public Customer(Car_MT car){this.car = car;}  //생성자 소비패턴...?
    

    @Override
    public void run() {
      String carName = "";
      for(int i=0; i<20; i++){
          carName = car.getCar();
          Thread t= Thread.currentThread();
          car.pop(t);
          try {
              Thread.sleep((int)(Math.random()*200));
          } catch (InterruptedException ex) {
              ex.printStackTrace();
          }
          
      }
    }
    
    
}
