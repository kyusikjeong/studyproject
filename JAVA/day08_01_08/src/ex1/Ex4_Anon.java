package ex1;
//익명은 참조 주소가 없이 객체를 생성하는 것을 의미 하는데
//익명 내부 클래스는 인터페이스, 추상클래스는 new 연산자로 생성할 수 없고
//익명 내부 클래스로 정의한 후 자원을 호출하는 형태이다.
//그외에 일반 클래스도 익명 내부 클래스를 만들어서 사용할 수 있다.

public class Ex4_Anon {
	//멤버영역에서 익명 내부클래스를 정의
	MyTest test = new MyTest() { //인터페이스는 객체생성이 안되지만 new를 사용해서 재정의 함으로써 메모리 주소에 값을 할당시킬수 있다
		//그러면 test의 참조변수를 통해 메모리주소에 생성된 printData()에 접근해서 사용할 수 있게 된다.
		@Override
		public void printData() {
			System.out.println("data2: "+data);
		}
	};
	
	public Ex4_Anon() {
		test.printData();
	}
	
	public void mytest() {
		//로컬 내부클래스 영역에서 사용이 됨
		new MyTest() {
			@Override
			public void printData() {
				System.out.println("data : "+data);
			}
		}.printData();
	}
	
	public static void main(String[] args) {
		//참조자료형 , 변수없이 바로 생성후 메서드 호출
		//new Ex4_Anon().mytest();
		Ex4_Anon ref = new Ex4_Anon();
		ref.mytest();
	}
}
