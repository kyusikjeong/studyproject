package exam1;

import java.util.Scanner;

public class Exam4_Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//UI
		String name = sc.nextLine();
		String age = sc.nextLine();
		String addr = sc.nextLine();
		
		//������ ���ڿ� ���� ������ �����ϴ� �޼��带 ȣ��
		int aget = Integer.parseInt(age) -1 ;
		//output
		System.out.println("�̸� :" + name + ", ���� : "+age+", ��°� : "+addr);
		System.out.println("������ : "+aget);
		
		
	}
}
