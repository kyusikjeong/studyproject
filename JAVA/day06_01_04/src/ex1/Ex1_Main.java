package ex1;

public class Ex1_Main {
	public static void main(String[] args) {
		//추상 클래스는 해당 부모 클래스가 다른 클래스에서 참조되지 않도록 할때도 설계해서 사용한다.
		Ex1_Parent ref = new Ex1_Parent();
		ref.moveMountain();
		//익명 내부 클래스로 정의 됨!
		
		new Ex1_Parent() {
			@Override
			public void moveMountain() {
				System.out.println("새로운 재정의!");
			}
		}.moveMountain();
	}
}
