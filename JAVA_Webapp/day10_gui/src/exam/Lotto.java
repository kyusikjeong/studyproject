/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

/**
 *
 * @author KOSTA
 */
public class Lotto {
    LottoInter li;
    public Lotto(){
        li = new LottoGame();
        Scanner sc = new Scanner(System.in);
        System.out.println("금액을 입력하세요");
        li.setLottoGameNum(sc.nextInt());
        
     
        
    }
   public static void main(String[] args) {
        new Lotto();
        
        
        
//        TreeSet<Integer> num = new TreeSet();
//        
//        Loop:  while(true){
//            int rNum = (int)(Math.random()*45)+1;
//            num.add(rNum);
//           if (num.size() == 6){
//                System.out.println("금주의 번호");
//                for(int e: num){
//                    System.out.print(e+" ");
//                 }break Loop;
////                while(it.hasNext()){
////                    int e =  it.next();
////                    System.out.print(e+" ");
////                    
////               }
//            }
//        }
    }
    
}
