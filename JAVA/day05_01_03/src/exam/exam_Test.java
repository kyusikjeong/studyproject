package exam;

import java.util.Scanner;



public class exam_Test {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//UI = 1.�Է� 2. ��� 3. ����
		
		String[][]str ;
	
		str = new String[2][5];
		while(true) {
			for(String[] out :str) {
				for(String in:out) {
					
					System.out.println("��ȣ : ");
					int num = Integer.parseInt(sc.nextLine());
					System.out.println("�̸� : ");
					String name = sc.nextLine();
					System.out.println("���̵� : ");
					String id = sc.nextLine();
					System.out.println("���� : ");
					int age = Integer.parseInt(sc.nextLine());
					System.out.println("�̸��� ���� ���� : 1:���� , 2.�ź� =>");
					int agree = Integer.parseInt(sc.nextLine());
					//POJO�� �Է¹��� ���� Setter�� ����
					
					exam_Setget set = new exam_Setget();
					set.setNum(num);
					set.setName(name);
					set.setId(id);
					set.setAge(age);
					
					if(agree == 1) {
						set.setAgree(true);
					} else if(agree == 2) {
						set.setAgree(false);
					}
					
				}
			}
		}
	}
}
