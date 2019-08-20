package exam;

import java.util.Scanner;

public class CellPhoneExample {
	public static void main(String[] args) {
		SmartPhone smartPhone = new SmartPhone("아이폰", "화이트골드");
		DmbCellPhone dmbCellPhone = new DmbCellPhone("dmb폰", "블루");
		//CellPhone smartPhone = new SmartPhone("아이폰", "화이트골드");
		//이런식으로 부모의 참조자료형으로 선언한다면 부모의 멤버까지만 접근 할 수 있다.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("스마트폰 모델 : "+smartPhone.getModel());
		System.out.println("스마트폰 색상 : "+smartPhone.getColor());
		
		smartPhone.powerOn();
		smartPhone.bell();
		smartPhone.sendVoice("여보세요");
		smartPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
		smartPhone.sendVoice("네, 반갑습니다");
		smartPhone.hangUp();
		
		smartPhone.bluetoothOn();
		smartPhone.wifiOn();
		
		smartPhone.status();
//		
//		System.out.println("dmb폰 모델 : "+dmbCellPhone.getModel());
//		System.out.println("dmb폰 색상 : "+dmbCellPhone.getColor());
//		
//		System.out.println("채널 :"+dmbCellPhone.getChannel());
//		
//		dmbCellPhone.turnOnDmb();
//		dmbCellPhone.changeChannelDmb(9);
//		dmbCellPhone.turnOffDmb();
	}
}
