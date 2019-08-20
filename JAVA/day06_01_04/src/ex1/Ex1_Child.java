package ex1;

public class Ex1_Child extends Ex1_Parent{
	
	//2.Object 의 메서드를 재정의 한것
	
	@Override
	public String toString() {
		return String.valueOf("상속받은 금액"+getPay());
		
	}
	//1.재정의 해야만 Ex1_Parent를 상속 받을 수 있다.
	@Override
	public void moveMountain() {
		System.out.println("산을 성공적으로 옮긴 후 "+toString()+" 받았다.");
	}
	

}
