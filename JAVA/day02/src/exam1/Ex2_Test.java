package exam1;

import java.util.Scanner;

public class Ex2_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("금액을 입력하세요 : ");
		int price = Integer.parseInt(sc.nextLine());
		
	
		
		//앞의 항을 %하고 뒤의 것을 / 하면 됨
		
		System.out.println("500원짜리 :" + (price / 500) + "개" );
		System.out.println("100원짜리 :" + (price % 500/ 100) + "개" );
		
		System.out.println("50원짜리 :" + (price %500%100/50) + "개" );
		
		System.out.println("10원짜리 :" + (price %500%100%50/10) + "개" );
		
	}
}
