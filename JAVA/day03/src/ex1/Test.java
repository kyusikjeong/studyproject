package ex1;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		int menu =  !sc.nextLine().equals("")? Integer.parseInt(sc.nextLine()): 0;
		System.out.println("menu "+menu);
		
		int balance = 0;
//		Loop: while(run) {
//			System.out.println("-----------------------");
//			System.out.println("1.���� | 2.��� | 3.�ܰ� | 4.����");
//			System.out.println("-----------------------");
//			System.out.print("����>");
//			
//			
//			Scanner sc = new Scanner(System.in);
//			int menu =  !sc.nextLine().equals("")? Integer.parseInt(sc.nextLine()): 0;
//			System.out.println(menu);
//			
//			
//			switch(menu) {
//			case 1:
//				System.out.println("���ݾ�>");
//				balance += Integer.parseInt(sc.nextLine());
//				System.out.println("balance :"+balance);
//				continue;
//			case 2:
//				System.out.println("��ݾ�>");
//				balance -= Integer.parseInt(sc.nextLine());
//				System.out.println("balance2 :"+balance);
//				continue;
//			case 3:
//				System.out.println("�ܰ�>"+balance);
//				System.out.println("balance3 :"+balance);
//				continue;
//			case 4:
//				System.out.println("���α׷� ����");	
//				break Loop;
//				
//			default:
//				continue;
//			}
//			
//		}
	
	}
		
		 
		
}
