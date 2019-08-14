package ex2;

import java.util.Scanner;

public class Ex10_IfElse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		
		System.out.print("점수를 입력하세요 : ");
		int score = Integer.parseInt(s.nextLine());
		String grade = "";
		
		if(score >=50) {
			grade = "고급";
		} else if(score >=30){
			grade = "중급";
		} else if(score >=20) {
			grade = "초급";
		} else {
			grade = "없음";
		}
		
		System.out.println("점수 : "+ score+"\n등급 : "+grade);
				
	}

}
