package ex2;

import java.util.Scanner;

public class Ex6_If {
	public static void main(String[] args) {
		if (true) {
			int n = 10;
			n++;
		}
		//System.out.println(n);   에러발생. if문 안의 지역변수를 호출했으므로.
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력해 주세요:");
		int num = Integer.parseInt(sc.nextLine());
//		
//			if(num<=19) {
//				
//			}
	}

}
