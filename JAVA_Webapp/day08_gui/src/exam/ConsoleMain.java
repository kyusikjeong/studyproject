package exam;

import java.util.Scanner;

public class ConsoleMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�̸�: ");
		String name = sc.nextLine();
		System.out.println("1.�ѱ��丮. 2.�߱��丮. 3. �ε� �丮 :");
		String menu = sc.nextLine();
		Service service = new Service(); //��ü����
                
		System.out.println(service.service(name,menu)); //service Ŭ���� ���� �޼ҵ� ����
        }
}
