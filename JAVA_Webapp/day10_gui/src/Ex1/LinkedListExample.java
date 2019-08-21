/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author KOSTA
 */
    
public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("리스트 선택. 1.ArrayList. 2.LinkedList");
        String user = sc.nextLine();
        LinkedListExample le = new LinkedListExample();
        if (user.equals("1")){
            le.timeCheck(new ArrayList());
        } else {
            le.timeCheck(new LinkedList());
        }
    }
    public void timeCheck(List<String> list){
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        for(int i=0; i<100000;i++){
            list.add(0,String.valueOf(i));
        }
        endTime = System.nanoTime();
        if (list instanceof ArrayList){
          System.out.println("ArrayList 걸린 시간: "+(endTime - startTime)+ " ns");
        } else if(list instanceof LinkedList){
          System.out.println("LinkedList 걸린 시간: "+(endTime - startTime)+ " ns");   
        }
    }
}
