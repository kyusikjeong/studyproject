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
        System.out.println("����� �̸�:");
        String name = sc.nextLine();
        System.out.println("�ݾ�:");
        int money = Integer.parseInt(sc.nextLine());
        GameService gService = new GameService(money);
        while(true){
        System.out.println("�޴� 1 - Ȧ, 2 - ¦, 3- ����");
        int user = sc.nextInt();
        gService.service(name,money,user);
        }
      }
        
    }
   

