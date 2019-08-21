package ex3;

import java.util.Scanner;

public class gameTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int winCount =0;
		int count = 0;
		float winRate;
		
		for(;;) {
			
			System.out.println("메뉴 1 - 홀, 2 - 짝 , 3- 종료");
			String menu = sc.nextLine();
			String user= "";
			
			if (menu.equals("2")){
				user = "짝";
			} else if (menu.equals("1")){
				user = "홀";
			} else {
				System.out.println("정확한 값을 입력하여 주십시오.");
			}
			
			int cpu = (int)(Math.random()*2);
			String cpuT = (cpu% 2 ==0) ? "짝" : "홀";
			
			if (menu.equals("3")) {
				
				//winRate = Math.round((float)winCount / count*100);  //반올림 필요할 시.
				winRate = (float)winCount / count*100;
				System.out.println("*****************************");
				System.out.println("게임 종료!");
				System.out.println("전체 게임수: "+count);
				System.out.println("이긴 횟수: "+winCount);
				System.out.println("승률: "+(int)winRate+"%");
				System.out.println("*****************************");
				
				if(winRate>=70) {
					System.out.println("승률이 70% 이상입니다. 경품 받아가세요.");
				} else {
					System.out.println("꽝. 다음 기회에...");
				}
				break;
				//승률이랑 7번 이상 상품 지급 텍스트 출력
			
			}
			if (user.equals(cpuT)) {
					winCount++;
					count++;
					System.out.println("-------------------------");
					System.out.println("No: "+count);
					System.out.println("CPU: "+cpuT);
					System.out.println("YOU: "+user);
					System.out.println("WIN");
				
			} else {
				count++;
				System.out.println("-------------------------");
				System.out.println("No: "+count);
				System.out.println("CPU: "+cpuT);
				System.out.println("YOU: "+user);
				System.out.println("LOSE");
				
			}
			
		}
		
		
		
		
		
		
		
//		
//		
//		public static void count(String user,String cpuT,int count) {  //메서드로 묶어주면 코드가 줄어들겠지
//			System.out.println("-------------------------");
//			System.out.println("No: "+count);
//			System.out.println("CPU: "+cpuT);
//			System.out.println("YOU: "+user);
//		}
	}
}