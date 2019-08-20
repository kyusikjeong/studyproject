package ex3;

public class B {

	private int bb;  //private 접근지정자를 걸어서 제한을 거는것을 정보 은닉화
	private A aRef;
	//has ' a관계
	public B() {
		//bb = 2;
		aRef = new A();
	}
	public int getBb() { //getter로 데이터를 제공하는것을 캡슐화
		return bb;
	}
	public A getaRef() {
		return aRef;
	}
	public B(int b) {
		bb = b;
		System.out.println("B클래스 안의 "+bb);
	}
	public B(A a, int c) {
		
	}
	
}
