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
        ///�Է¹��� �̸��� ����� �ȳ��ϼ��� xx�� �ݰ�����.
//        StringBuffer sb = new StringBuffer();
//        sb.append("�ȳ��ϼ���. ").append(name).append("�� �ݰ����ϴ�. \n");
      MyMessageDemo mmd = new MyMessageDemo();
      
        System.out.println(mmd.makeMessage(name));
    }
}
