package ex2;

import java.util.Scanner;

public class Ex10_IfElse {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		
		
		System.out.print("������ �Է��ϼ��� : ");
		int score = Integer.parseInt(s.nextLine());
		String grade = "";
		
		if(score >=50) {
			grade = "���";
		} else if(score >=30){
			grade = "�߱�";
		} else if(score >=20) {
			grade = "�ʱ�";
		} else {
			grade = "����";
		}
		
		System.out.println("���� : "+ score+"\n��� : "+grade);
				
	}

}
