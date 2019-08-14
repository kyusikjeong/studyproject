package exam1;

public class Exam1Hello { //프로그램 실행시 jvm이 main 메서드를 찾고 실행시킨다.
	public static void main(String[] args) { 
		System.out.println("안녕하세요");
		System.out.println("저는 정규식입니다.");
		System.out.println("현재 거주지는 안양에 위치하고 있습니다.");
		System.out.println("앞으로 잘 부탁드립니다.");
		System.out.println("감사합니다");
		
		System.out.println("메인메서드 실행");
		test();
	}
	
	public static void test() {
		//메서드 영역	
		System.out.println("test메서드를 실행");
	}
}
