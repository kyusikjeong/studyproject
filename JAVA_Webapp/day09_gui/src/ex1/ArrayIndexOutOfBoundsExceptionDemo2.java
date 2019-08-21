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
public class ArrayIndexOutOfBoundsExceptionDemo2 {
    public static void main(String[] args) {
        if (args.length ==2){
            String data = args[0];
            String data2 = args[1];
            System.out.println("args[0]"+data);
            System.out.println("args[0]"+data2);
        } else {
            System.out.println("[실행 방법]");
        }
    }
}
