package ex1;

public class Ex3_SubCar extends Ex3_SuperCar{
	
	public void testsub() {
		System.out.println("자식 클래스의 메서드 호출");
		
	}

	@Override //어노테이션. 실행가능한 주석이라는 것만 기억하고 넘어가자.
	public void carColor() {
		//super 부모클래스의 주소
		//super.carColor();
		System.out.println("컬러 변경 : 파란색");
	}
	
	public static void main(String[] args) {
		//부모를 참조 자료형으로 자식 클래스를 객체로 생성
		//부모의 자원만 참조가 가능하고
		//자식 객체인 Ex3_SubCar() 자원은 참조가 불가능하다.
		
		Ex3_SuperCar ref = new Ex3_SubCar();
		System.out.println(ref instanceof Ex3_SubCar);
		ref.carColor();
		ref.testSuper();
		//ref.testsub(); // -> 참조자료형이 부모클래스이기 때문에
		//참조할 수 없다. (but 생성은 되었지만....)
		
	}
	
}
