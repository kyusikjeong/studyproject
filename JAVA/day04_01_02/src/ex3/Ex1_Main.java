package ex3;

import java.util.Scanner;

import ex2.Ex3_PojoDemo;

public class Ex1_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// UI
		
		System.out.println("번호 : ");
		int num = Integer.parseInt(sc.nextLine());
		System.out.println("이름 : ");
		String name = sc.nextLine();
		System.out.println("아이디 : ");
		String id = sc.nextLine();
		System.out.println("나이 : ");
		int age = Integer.parseInt(sc.nextLine());
		System.out.println("이메일 수신 동의 : 1:동의 , 2.거부 =>");
		int agree = Integer.parseInt(sc.nextLine());
		//POJO에 입력받은 값을 Setter로 저장
		
		Ex3_PojoDemo ep = new Ex3_PojoDemo();
		ep.setNum(num);
		ep.setName(name);
		ep.setId(id);
		ep.setAge(age);
		
		if(agree == 1) {
			ep.setAgree(true);
		} else if(agree == 2) {
			ep.setAgree(false);
		}
		System.out.println("검사");
		System.out.println("회원의 아이디값: "+ep.getId());
		
		//비지니스 로직을 갖춘 클래스를 통해서 (기능 사용)
		//Ex1_PojoMember 클래스를 객체로 생성한다.
		
		Ex1_PojoMember em = new Ex1_PojoMember();
		em.setMember(ep);//입력한 회원중에 성인만 저장!
		em.printMember();// 입력된 회원의 정보 출력
		
		
		
		
	}
}
