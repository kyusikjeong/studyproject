package exam1;

import java.util.Scanner;

public class Ex1_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� �Է��ϼ��� : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println( (num%2 ==0) ? "¦���Դϴ�" : "¦���� �ƴմϴ�");
		
	}

}
