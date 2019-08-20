package ex1;

public class Ex2_DefaultImple implements Ex2_Jdk8{
	//강제로 재정의 되는 것은 추상메서드
	@Override
	public void num1() {
		System.out.println("본사의 비법을 써봅시다.");
		System.out.println("------------------");
		System.out.println(test2());
		System.out.println("------------------");
		//interface 가 가지고 있는 static 메서드도 호출해봅시다.
	}

	public static void main(String[] args) {
		Ex2_Jdk8 ref = new Ex2_DefaultImple();
		ref.num1();
		ref.test2();
	}
}
