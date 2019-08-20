package ex1;
//기본 : interface 정의 : 상수와 추상메서드로 구성되어 있다.
//jdk 7버전 이상부터 default, static 이 추가됨!

public interface Ex1_Inter {
	public static final int num1 = 10;//상수
	abstract public void test(); //추상메서드
	
	//축약형
	public int num2 = 20;//상수
	public void test2(); //추상메서드
	
}
