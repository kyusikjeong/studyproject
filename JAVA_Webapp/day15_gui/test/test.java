
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KOSTA
 */
public class test {
    
    public static void main(String[] args) {
        String test = "1,2";
        StringTokenizer st = new StringTokenizer(test);
        String test1=""
                ,test2="";
        while(st.hasMoreTokens()){
        for(int i=0;i<2; i++){
            if(i==0){
              test1 = st.nextToken(",");
            } else if(i == 1){
              test2 = st.nextToken(",");
            }
         }
        }
        
        System.out.println(""+test1);
        System.out.println(""+test2);
        }
    }

