package exam;

import java.util.Scanner;

public class CookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ֹ����̸�: ");
		String name = sc.nextLine();
		System.out.println("1.�ѱ��丮. 2.�ε��丮");
		String menu = sc.nextLine();
		ServiceCook service = new ServiceCook(); 
		service.service(name,menu);  //������ ����ǰ� �̸� �� ���ð��� �Է¹��� �� service ��ü�� service�޼ҵ带 ȣ���Ѵ�.
	}
}
