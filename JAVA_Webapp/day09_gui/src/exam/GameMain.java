/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Scanner;

public class GameMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("사용자 이름:");
        String name = sc.nextLine();
        System.out.println("금액:");
        int money = Integer.parseInt(sc.nextLine());
        GameService gService = new GameService(money);
        while(true){
        System.out.println("메뉴 1 - 홀, 2 - 짝, 3- 종료");
        int user = sc.nextInt();
        gService.service(name,money,user);
        }
      }
        
    }
   

