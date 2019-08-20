package ex2;

import ex1.Ex1_Main;


public class Ex2_Main {
	public static void main(String[] args) {
		Ex2_MethodDemo ref = new Ex2_MethodDemo(); //우리집 //heap 에 객체생성
		
		Ex2_ColorOffice eo1 = new Ex2_ColorOffice();//A
		Ex2_ColorOffice eo2 = new Ex2_ColorOffice();//B
		
		
		
		
		//메서드 인자값으로 우리집의 주소를 각각 전달한다면..
		
		//같은 주소를 보고 있다는 개념
		//메서드 호출시 ref 즉 홈의 주소값을 전달하고 있다.
		
		eo1.jobPaint(ref, "노란색"); //100번지 주소값
		eo2.jobPaint(ref, "레드");
		
		//메모리 구조를 그리면서 왜 red 가 나오는지 한번 생각해보자
		
		System.out.println("색상 확인 : "+ref.viewColor());
		
	}
}
