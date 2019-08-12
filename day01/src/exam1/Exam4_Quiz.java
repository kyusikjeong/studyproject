package exam1;

import java.util.Scanner;

public class Exam4_Quiz {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//UI
		String name = sc.nextLine();
		String age = sc.nextLine();
		String addr = sc.nextLine();
		
		//숫자형 문자열 값을 정수로 변경하는 메서드를 호출
		int aget = Integer.parseInt(age) -1 ;
		//output
		System.out.println("이름 :" + name + ", 나이 : "+age+", 사는곳 : "+addr);
		System.out.println("만나이 : "+aget);
		
		
	}
}
