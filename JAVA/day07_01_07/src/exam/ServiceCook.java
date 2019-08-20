package exam;
//오늘 스터디: 인터페이스 팀별 학습문제
//멤버 내부클래스 복습

import java.util.Scanner;

public class ServiceCook {
	//서비스가 인터페이스를 사용하는 방식
	//앞에 예문 참조
	//1.결과물 UML
	//2.소스
	//비즈니스 로직
	
	//MyInter in;

	public void service(String name, String menu) { //main에서 입력받은 값으로 메소드 실행.
		if(menu.equals("1")) {
//			in = new KoreaCook();  //이런 식으로도 객체생성 후 실행이 된다..
//			in.orderCook(name);
			new KoreaCook().orderCook(name);  //메뉴가 1이면 KoreaCook 객체 생성후 내부의 orderCook메서드를 호출
		}else if(menu.equals("2")){
			new IndoCook().orderCook(name);  //메뉴가2이면 orderCook 객체 생성후 내부의 orderCook메서드를 호출
		}
	}
	
}
