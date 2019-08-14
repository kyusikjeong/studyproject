package ex2;

import java.util.Scanner;

public class Ex9_IfElseIf {
	public static void main(String[] args) {
		//작성할때부터 Scanner 적용
		//하나의 조건을 여러번 판별 하려고 할 때 사용한다.
		Scanner s = new Scanner(System.in);
		
		String val = s.nextLine();
		
		String col = "";
		if(val.equals("사과")) {
			col = "Red";
		} else if(val.equals("바나나")) {
			col = "Yellow";
		} else if(val.equals("오렌지")) {
			col = "Orange";
		} else {
			col = "White";
			
		}
		
		System.out.println(val+"은(는) " +col+ "색 입니다.");
	}
}
