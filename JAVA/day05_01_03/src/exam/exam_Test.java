package exam;

import java.util.Scanner;



public class exam_Test {
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		//UI = 1.입력 2. 출력 3. 종료
		
		String[][]str ;
	
		str = new String[2][5];
		while(true) {
			for(String[] out :str) {
				for(String in:out) {
					
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
					
					exam_Setget set = new exam_Setget();
					set.setNum(num);
					set.setName(name);
					set.setId(id);
					set.setAge(age);
					
					if(agree == 1) {
						set.setAgree(true);
					} else if(agree == 2) {
						set.setAgree(false);
					}
					
				}
			}
		}
	}
}
