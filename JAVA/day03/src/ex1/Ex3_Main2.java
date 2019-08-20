package ex1;

import java.util.Scanner;

public class Ex3_Main2 {
	//1.메인메서드를 정의(JVM이 실행)
	public static void main(String[] args) {
		//2.Ex3_Remocon 클래스를 객체로 생성하자.
		//참조자료형 참조변수 = new 생성할객채();
		//Stack에서 선언된 Ex3_Remocon을 참조자료형으로 한
		//변수 er에는 Heap 영역에 new 연산자로 생성된 객체의 주소(100)가
		//저장 되어 있다. 그러므로 er 변수로 Ex3_Remocon객채를 참조해서
		//사용할 수 있다.
		Ex3_Remocon er = new Ex3_Remocon();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("전원켜기 1, 전원끄기 2  :");
			String powerMsg = sc.nextLine();
			if(powerMsg.equals("1")) {
				
				er.setPower(true);
				System.out.println("채널 값 :");
				int chNumber = Integer.parseInt(sc.nextLine());
				er.setChNum(chNumber);
				
			} else if (powerMsg.equals("2")) {
				er.setPower(false);
			} else {
				System.out.println("잘못된 번호 입니다.");
//				System.exit(0);
//				break;
			}
		}
		
	}
}
