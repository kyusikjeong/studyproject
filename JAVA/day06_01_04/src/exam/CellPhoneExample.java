package exam;

import java.util.Scanner;

public class CellPhoneExample {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("������", "ȭ��Ʈ���");
		DmbCellPhone dmbCellPhone = new DmbCellPhone("dmb��", "���");
		//CellPhone smartPhone = new SmartPhone("������", "ȭ��Ʈ���");
		//�̷������� �θ��� �����ڷ������� �����Ѵٸ� �θ��� ��������� ���� �� �� �ִ�.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("����Ʈ�� �� : "+smartPhone.getModel());
		System.out.println("����Ʈ�� ���� : "+smartPhone.getColor());
		
		smartPhone.powerOn();
		smartPhone.bell();
		smartPhone.sendVoice("��������");
		smartPhone.receiveVoice("�ȳ��ϼ���! ���� ȫ�浿�ε���");
		smartPhone.sendVoice("��, �ݰ����ϴ�");
		smartPhone.hangUp();
		
		smartPhone.bluetoothOn();
		smartPhone.wifiOn();
		
		smartPhone.status();
//		
//		System.out.println("dmb�� �� : "+dmbCellPhone.getModel());
//		System.out.println("dmb�� ���� : "+dmbCellPhone.getColor());
//		
//		System.out.println("ä�� :"+dmbCellPhone.getChannel());
//		
//		dmbCellPhone.turnOnDmb();
//		dmbCellPhone.changeChannelDmb(9);
//		dmbCellPhone.turnOffDmb();
	}
}
