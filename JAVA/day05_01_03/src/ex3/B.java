package ex3;

public class B {

	private int bb;  //private ���������ڸ� �ɾ ������ �Ŵ°��� ���� ����ȭ
	private A aRef;
	//has ' a����
	public B() {
		//bb = 2;
		aRef = new A();
	}
	public int getBb() { //getter�� �����͸� �����ϴ°��� ĸ��ȭ
		return bb;
	}
	public A getaRef() {
		return aRef;
	}
	public B(int b) {
		bb = b;
		System.out.println("BŬ���� ���� "+bb);
	}
	public B(A a, int c) {
		
	}
	
}
