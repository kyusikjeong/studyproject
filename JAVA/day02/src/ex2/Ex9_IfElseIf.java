package ex2;

import java.util.Scanner;

public class Ex9_IfElseIf {
	public static void main(String[] args) {
		//�ۼ��Ҷ����� Scanner ����
		//�ϳ��� ������ ������ �Ǻ� �Ϸ��� �� �� ����Ѵ�.
		Scanner s = new Scanner(System.in);
		
		String val = s.nextLine();
		
		String col = "";
		if(val.equals("���")) {
			col = "Red";
		} else if(val.equals("�ٳ���")) {
			col = "Yellow";
		} else if(val.equals("������")) {
			col = "Orange";
		} else {
			col = "White";
			
		}
		
		System.out.println(val+"��(��) " +col+ "�� �Դϴ�.");
	}
}
