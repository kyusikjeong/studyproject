/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day13_gui;

  
 
public class Day13_gui {
    
  public Day13_gui(){
    
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       
        Ex_ThreadExtends tr = new Ex_ThreadExtends();
      
        Thread t2 = new Thread(new Ex_ThreadImplements());
          tr.start();
          tr.join();
        t2.start();
    }
    
}
