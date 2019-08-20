package ex1;

import java.util.Scanner;

public class Ex3_Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int i = 0;
		Loop: while(true) {
			System.out.println("메뉴 선택: 1- 입력, 2- 출력, 3- 종료: ");
			int menuNum = Integer.parseInt(sc.nextLine());
			//switch 문으로 변경
			
			switch(menuNum) {
			case 1:
				System.out.println("입력 처리");
				break;
			case 2:
				System.out.println("출력 처리");
				break;
			case 3:
				System.out.println("종료 처리");
				break Loop;
			}
			i++;
		}
	}
}
