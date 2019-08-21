package exam;

import java.util.Scanner;

public class ConsoleMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("이름: ");
		String name = sc.nextLine();
		System.out.println("1.한국요리. 2.중국요리. 3. 인도 요리 :");
		String menu = sc.nextLine();
		Service service = new Service(); //객체생성
                
		System.out.println(service.service(name,menu)); //service 클래스 안의 메소드 실행
        }
}
