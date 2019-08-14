package ex1;

public class Ex1_boolean {
	public static void test() {//메서드 (함수) 정의
		System.out.println("test");
		//System.out.println("boolean 의 재사용된 값 :"+chk);
	
	}
	public static void main(String[] args) {
		test();
		//지역변수. 지역변수는 선언한 브레이스 안에서만 사용 할 수 있다. 
		//변수명이 chk인 boolean 자료형으로 선언
		boolean chk = false;
		System.out.println("boolean 값:"+chk);
		//재사용
		chk = true;
		System.out.println("boolean 재사용 값:"+chk);
	}
}
