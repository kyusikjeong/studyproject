package ex3;

public class Ex1_MemberInner extends SuperA{
	//기본 접근 제한자
	int numA;
	//클래스 내부에서만 접근이 가능
	private int numB;
	private int numC;
	public Ex1_MemberInner() {
		numA = 10; numB = 100; numC = 200;
	}
	//멤버 영역에 클래스를 정의: 멤버 내부 클래스
	
	public class Inner extends SuperB{
		public void printData() {
			System.out.println("int A: "+numA);
			System.out.println("int B: "+numB);//접근가능
			System.out.println("int C: "+numC);
			
		}
	}
	
	public static void main(String[] args) {
		Ex1_MemberInner test = new Ex1_MemberInner();
		SuperB s = new SuperB();
		s.superB();
	}
}
