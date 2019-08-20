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
//			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
//			System.out.println("-----------------------");
//			System.out.print("선택>");
//			
//			
//			Scanner sc = new Scanner(System.in);
//			int menu =  !sc.nextLine().equals("")? Integer.parseInt(sc.nextLine()): 0;
//			System.out.println(menu);
//			
//			
//			switch(menu) {
//			case 1:
//				System.out.println("예금액>");
//				balance += Integer.parseInt(sc.nextLine());
//				System.out.println("balance :"+balance);
//				continue;
//			case 2:
//				System.out.println("출금액>");
//				balance -= Integer.parseInt(sc.nextLine());
//				System.out.println("balance2 :"+balance);
//				continue;
//			case 3:
//				System.out.println("잔고>"+balance);
//				System.out.println("balance3 :"+balance);
//				continue;
//			case 4:
//				System.out.println("프로그램 종료");	
//				break Loop;
//				
//			default:
//				continue;
//			}
//			
//		}
	
	}
		
		 
		
}
