package ex1;

import java.util.Scanner;

public class Ex5_MathRandom {
	public static void main(String[] args) {
		int comNum = (int)(Math.random()*10)+1;
	
		System.out.println("1���� 10������ �����߿��� �ϳ��� �Է��ϼ���: ");
		Scanner sc = new Scanner(System.in);
		
		int uNum = Integer.parseInt(sc.nextLine());
		System.out.println("cpu�� �� : "+comNum+" / "+"�Է��� �� : "+uNum+" / ��ġ���� :"+(comNum == uNum ? "�¾ҽ��ϴ�" : "Ʋ�Ƚ��ϴ�"));
		//���� : Scanner, Integer.parseInt(),sout ... random
		//����� UI : 
		//1 ~ 10 ������ �����߿� �ϳ� �Է�
		
		/* String msg ="";
		 * if(uNum == comNum) {
		 * 		msg = "�¾ҽ��ϴ�";
		 * } else {
		 * 		msg = "Ʋ�Ƚ��ϴ�";
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
	}
}
