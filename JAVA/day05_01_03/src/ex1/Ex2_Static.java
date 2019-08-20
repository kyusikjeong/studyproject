package ex1;

public class Ex2_Static {
	//  static 은 공유. static 멤버들은 생성없이 사용가능. 일반 클래스는 생성해야 사용가능
	//	오직 하나만 생성해서 여러 객체가 공유해서 사용할 수 있는 자원
	//	static 공간에 정의 되고 있기 때문에 생성없이 접근 및 사용 된다 
	//	static이 붙으면 실제 모든 자원은 JVM의 영역 중에 static영역에 위치한다
	
	public static int num1= 1; //static 변수(멤버필드)
	private int num2;		//인스턴스 변수(멤버 필드)
	public void startTest() {
		num1++;
		num2++;
	}
	
	public static int getNum1() { //static 붙으면 static 메소드
		return num1;
		
	}
	public int getNum2() { //인스턴스 메소드
		return num2;
	}
	
	public static void main(String[] args) {
		
	}
	
}
