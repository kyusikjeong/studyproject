package ex1;
//클래스 구성
//1.헤더
//2.멤버필드
//3.멤버메서드
//클래스는 객체지향으로 설계(재사용),통상 메인메서드는 포함되지 않는다.

public class Ex2_ClassDemo {
	//******** 멤버필드는 선언과 동시에 초기화 됨!
	int pay;
	String team;
	
	//메서드를 한번 만들어(정의)보면서 의미를 파악해보자.
	//public static void main(String[] args) {
	public void test() {// Ex2_ClassDemo클래스가 객체로 생성된 이후. 멤버메서드
		System.out.println("Pay : "+pay+", Team : "+team);
	}
	//테스트 후 18~21 주석 처리하고 Ex2_Main 만들고 구현ㄴ
	/*
	 * public static void main(String[] args) { Ex2_ClassDemo ref = new
	 * Ex2_ClassDemo(); ref.test();
	 * 
	 * }
	 */
	
	//의미있는 작업으로 메서드를 정의 해봅시다.
	//pay 에 어떤 값을 저장할 수 있도록 제공하는 메서드  만들기
	//반환형을 결정할 때 고민해야 할 것: 메서드 호출 후에 특정 값을 반환 받을 것인지
	//받을 값이 없으면 메서드만 수행할 것인지.
	//값을 넣는 작업에 대해서 반환값을 받을 필요가 없다고 생각하면 void를 써주면 된다.
	
	public void insertPay(int p) {//지역 변수
		pay = p;
		System.out.println("LOG1 : 지역변수 pay: "+p); //전역변수와 지역변수의 이름이 같을때는 지역변수의 우선순위가 높다
		System.out.println("LOG2 : 멤버필드 pay: "+pay); //지역변수는 선언한 범위 안에서만 사용이 가능하다는것을 꼭 기억할것
		
		//1.team에 값을 저장하는 메서드를 만들기.
		//2.pay, team 의 값을 동시에 저장하는 메서드 만들기
		
	}
	
	public void setTeam(String tname) {
		team = tname;
		
	}
	
	public void setValue(int p , String tname) {
		pay = p;
		team = tname;
	}

}
