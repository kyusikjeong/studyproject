package ex1;
//외부의 클래스를 불러올 때 사용
import java.util.Scanner;

public class Ex5_Scanner {
	public static void main(String[] args) {
		//키보드로부터 입력값을 입력받기 위한 클래스
		//생성해서 한번 사용 해봅시다. 따라하기.
		//참조 자료형 변수명 = new 생성한 클래스명();
		//System.out 은 출력
		//System.in 은 입력 
		//참조변수에는 생성된 객체의 주소값이 저장 100번지..
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 :");
		//sc 참조 변수를 사용해서 nextLine()을 호출해서 입력된 값을
		//문자열로 반환한다.
		String msg = sc.nextLine(); // 대기(한줄단위로 입력 후 enter)
		System.out.println("res :" + msg);
		System.out.println("이름 :");
		
		
		String name = sc.nextLine(); //생성되어있는 코드를 재사용...
		System.out.println("name: "+name);
		
		
	}
}
