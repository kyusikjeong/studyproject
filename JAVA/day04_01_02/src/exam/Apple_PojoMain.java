package exam;

import java.util.Scanner;

public class Apple_PojoMain { //���θ޼���.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		
			System.out.println("������ ����");
			String type = sc.nextLine();
			if(type.equals("") || type == null) {
				System.out.println("���� �Է��ϼž� �մϴ�.");
				continue;
			} 
			System.out.println("������ ������");
			String origine = sc.nextLine();
			System.out.println("������ ����. 1.����,  2.���� ����. 3.�ǸźҰ�");
			int status = Integer.parseInt(sc.nextLine());
			System.out.println("������ ũ��");
			int size = Integer.parseInt(sc.nextLine());
			Apple_Pojo ap = new Apple_Pojo();
			
			ap.setType(type);
			ap.setOrigine(origine);
			ap.setStatus(status);
			ap.setSize(size);
			
			Apple_PojoCheck apChk = new Apple_PojoCheck();
			
			
			apChk.setCheck(ap);
			apChk.printCheck();
			
			break;
		}
		
		
		
		
		
		
	}
}
