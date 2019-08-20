package ex1;

public class Ex3_StaticInnerMain {
	public static void main(String[] args) {
		//static 은 생성없이 사용 가능하다.
		//여러 객체가 생성해서 참조(공유)하더라도 static 영역에 오직 하나만.
		//static 을 소유한 외부 클래스.static 자원
		//외부 클래스.this 처럼.
		
		Ex3_StaticInner.Inner.printData();
		System.out.println("-----------------");
		//printData2 호출해보자
		
		new Ex3_StaticInner().Inner().printData2();
		Ex3_StaticInner.Inner ref = new Ex3_StaticInner().Inner();
		ref.printData2();
	}
}
