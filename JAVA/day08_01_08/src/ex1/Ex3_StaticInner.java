package ex1;

public class Ex3_StaticInner {
	int numA;
	private int numB;
	static int numC = 500;
	public void test() {
		System.out.println("Test!");
	}
	public Ex3_StaticInner() {
		numA = 10; numB = 100; numC = 200;
	}
	
	//내부 클래스 안에서 static 자원이 있으면// 무조건 static 내부 클래스로 정의해야 한다.
	public static class Inner{
		static int d = 10000;
		public static void printData() {
//			System.out.println("int A: "+numA); //static 영역에 생성되었으므로 일반 전역변수에는 접근할 수 없다.
//			System.out.println("int B: "+numB); //객체로 생성한 뒤 접근해야함.
			System.out.println("int C: "+numC);
			System.out.println("int D: "+d);
		}
		public void printData2() {
		
			System.out.println(" C: "+numC);  
			System.out.println(" D: "+d);
		}
	}
}
