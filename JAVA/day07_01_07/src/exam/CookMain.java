package exam;

import java.util.Scanner;

public class CookMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("주문자이름: ");
		String name = sc.nextLine();
		System.out.println("1.한국요리. 2.인도요리");
		String menu = sc.nextLine();
		ServiceCook service = new ServiceCook(); 
		service.service(name,menu);  //메인이 실행되고 이름 및 선택값을 입력받은 후 service 객체의 service메소드를 호출한다.
	}
}
