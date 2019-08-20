package exam;

import java.util.Scanner;

public class Exam_Main {
	public static void main(String[] args) {
		Exam4_Aircon air = new Exam4_Aircon();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("1.전원 켜기. 2.전원 끄기");
		String powerMsg = sc.nextLine();
		int condition = 0;
		while(true) {
				if(powerMsg.equals("1")) {
					if(condition ==0) {
						air.setPower(true);
						condition++;
					}
					
					System.out.println("1.온도상승. 2.온도 감소. 3. 옵션선택.4.종료");
					int optionNum = Integer.parseInt(sc.nextLine());
					
					switch(optionNum) {
					case 1:
						air.setTemp(true);
						continue;
					case 2:
						air.setTemp(false);
						continue;
					case 3:
						System.out.println("바꿀 옵션을 선택하여 주십시오.");
						System.out.println("1.강풍. 2.약풍. 3.미풍");
						int option = Integer.parseInt(sc.nextLine());
						air.setOption(option);
						break;
					case 4:
						System.out.println("전원이 꺼졌습니다.");
						System.exit(0);
					default:
						System.out.println("잘못된 번호입니다.");	
					
					}
				
			} else if (powerMsg.equals("2")) {
				air.setPower(false);
			} else {
				System.out.println("잘못된 번호 입니다.");
			
			}
		}
	}
}
