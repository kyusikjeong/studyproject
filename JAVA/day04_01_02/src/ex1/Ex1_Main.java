package ex1;

public class Ex1_Main {
	public static void main(String[] args) {
		//이미 설계된 Ex1_ClasseDemo를 객체로 생성하는 방법을 알고 있어요.
		Ex1_ClassDemo ref = new Ex1_ClassDemo();
		//참조는 . 연산자를 사용해서 사용합니다.
		ref.pay = 10000; //생성된 Ex1_ClassDemo의 주소(100)으로 참조해서 변수 pay에 값을 10000으로 기억
		System.out.println("ref.pay = "+ref.pay);
		
		ref.team = "test";
		System.out.println("ref.team = "+ref.team);
		//Ex1_ClassDemo 가 가지고 있는ㄷ필드안에서 team이란 속성에 적당한 값을 저장하고 출력해봅시다.
		
	}
}
