package ex3;

import ex2.Ex3_PojoDemo;

public class Ex1_PojoMember {
	//1.회원의 정보를 기억하는 클래스를 멤버로 저장
	//객체의 기본값은 null -> new생성안된 주소...
	private Ex3_PojoDemo ep; //100번지
	
	//2.Ex3_PojoDemo 의 객체를 생성한 후
	//현재 클래스의 멤버에 저장하는 메서드를 정의
	public void setMember(Ex3_PojoDemo ep) { //boolean setMember(~) 주고 유효성 체크에서 return false 주는방법도 생각.
		//들어오는 나이값을 판별해서 성년인지 미성년인지 구분하고 미성년이면 데이터를 입력하지 못하도록 구현
		if (ep.getAge()>=19) {
			this.ep = ep;
		} else {
			System.out.println("미성년자는 가입하실 수 없습니다.");
		}
		
	}
	
	//3.ep(회원)의 값을 출력하는 메서드
	public void printMember() {
		if(ep != null) {
			System.out.println("회원의 번호: "+ep.getNum());
			System.out.println("이름"+ep.getName());
			System.out.println("아이디: "+ep.getId());
			
			if (ep.isAgree() == true) {
				System.out.println("수신 동의 하였습니다");
				
			} else {
				System.out.println("수신 미동의 하였습니다.");
			}
		}
	}
}
