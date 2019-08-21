/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.util.Scanner;

/**
 *
 * @author KOSTA
 */
public class MyChatConsoleDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Name :");
        String name = sc.nextLine();
        ///입력받은 이름에 출력을 안녕하세요 xx님 반가워요.
//        StringBuffer sb = new StringBuffer();
//        sb.append("안녕하세요. ").append(name).append("님 반갑습니다. \n");
      MyMessageDemo mmd = new MyMessageDemo();
      
        System.out.println(mmd.makeMessage(name));
    }
}
