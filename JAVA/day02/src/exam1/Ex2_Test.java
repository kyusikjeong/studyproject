package exam1;

import java.util.Scanner;

public class Ex2_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ݾ��� �Է��ϼ��� : ");
		int price = Integer.parseInt(sc.nextLine());
		
	
		
		//���� ���� %�ϰ� ���� ���� / �ϸ� ��
		
		System.out.println("500��¥�� :" + (price / 500) + "��" );
		System.out.println("100��¥�� :" + (price % 500/ 100) + "��" );
		
		System.out.println("50��¥�� :" + (price %500%100/50) + "��" );
		
		System.out.println("10��¥�� :" + (price %500%100%50/10) + "��" );
		
	}
}
