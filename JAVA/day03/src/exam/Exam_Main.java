package exam;

import java.util.Scanner;

public class Exam_Main {
	public static void main(String[] args) {
		Exam4_Aircon air = new Exam4_Aircon();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("1.���� �ѱ�. 2.���� ����");
		String powerMsg = sc.nextLine();
		int condition = 0;
		while(true) {
				if(powerMsg.equals("1")) {
					if(condition ==0) {
						air.setPower(true);
						condition++;
					}
					
					System.out.println("1.�µ����. 2.�µ� ����. 3. �ɼǼ���.4.����");
					int optionNum = Integer.parseInt(sc.nextLine());
					
					switch(optionNum) {
					case 1:
						air.setTemp(true);
						continue;
					case 2:
						air.setTemp(false);
						continue;
					case 3:
						System.out.println("�ٲ� �ɼ��� �����Ͽ� �ֽʽÿ�.");
						System.out.println("1.��ǳ. 2.��ǳ. 3.��ǳ");
						int option = Integer.parseInt(sc.nextLine());
						air.setOption(option);
						break;
					case 4:
						System.out.println("������ �������ϴ�.");
						System.exit(0);
					default:
						System.out.println("�߸��� ��ȣ�Դϴ�.");	
					
					}
				
			} else if (powerMsg.equals("2")) {
				air.setPower(false);
			} else {
				System.out.println("�߸��� ��ȣ �Դϴ�.");
			
			}
		}
	}
}
