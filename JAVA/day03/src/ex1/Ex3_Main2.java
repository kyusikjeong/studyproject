package ex1;

import java.util.Scanner;

public class Ex3_Main2 {
	//1.���θ޼��带 ����(JVM�� ����)
	public static void main(String[] args) {
		//2.Ex3_Remocon Ŭ������ ��ü�� ��������.
		//�����ڷ��� �������� = new �����Ұ�ä();
		//Stack���� ����� Ex3_Remocon�� �����ڷ������� ��
		//���� er���� Heap ������ new �����ڷ� ������ ��ü�� �ּ�(100)��
		//���� �Ǿ� �ִ�. �׷��Ƿ� er ������ Ex3_Remocon��ä�� �����ؼ�
		//����� �� �ִ�.
		Ex3_Remocon er = new Ex3_Remocon();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("�����ѱ� 1, �������� 2  :");
			String powerMsg = sc.nextLine();
			if(powerMsg.equals("1")) {
				
				er.setPower(true);
				System.out.println("ä�� �� :");
				int chNumber = Integer.parseInt(sc.nextLine());
				er.setChNum(chNumber);
				
			} else if (powerMsg.equals("2")) {
				er.setPower(false);
			} else {
				System.out.println("�߸��� ��ȣ �Դϴ�.");
//				System.exit(0);
//				break;
			}
		}
		
	}
}
