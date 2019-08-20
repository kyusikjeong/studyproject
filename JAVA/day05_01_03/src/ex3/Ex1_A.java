package ex3;
/* Ex1_A: 부모 클래스*/
//부모 클래스는 재사용이 되는 클래스
//가장 기본이 되는 클래스로 설계 되어야 한다.
public class Ex1_A {
	int aa = 10;
	//자식 클래스가 생성이 될 떄 부모 클래스의 생성자가 먼저
	//호출이 된다.
	public Ex1_A() {
		System.out.println("부모 생성자 호출!");
	}
}
