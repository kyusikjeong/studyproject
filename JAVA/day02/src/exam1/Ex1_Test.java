package exam1;

import java.util.Scanner;

public class Ex1_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("값을 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println( (num%2 ==0) ? "짝수입니다" : "짝수가 아닙니다");
		
	}

}
