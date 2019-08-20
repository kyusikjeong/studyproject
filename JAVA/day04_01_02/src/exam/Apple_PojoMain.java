package exam;

import java.util.Scanner;

public class Apple_PojoMain { //메인메서드.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			
		
			System.out.println("과일의 종류");
			String type = sc.nextLine();
			if(type.equals("") || type == null) {
				System.out.println("값을 입력하셔야 합니다.");
				continue;
			} 
			System.out.println("과일의 원산지");
			String origine = sc.nextLine();
			System.out.println("과일의 상태. 1.정상,  2.흠이 있음. 3.판매불가");
			int status = Integer.parseInt(sc.nextLine());
			System.out.println("과일의 크기");
			int size = Integer.parseInt(sc.nextLine());
			Apple_Pojo ap = new Apple_Pojo();
			
			ap.setType(type);
			ap.setOrigine(origine);
			ap.setStatus(status);
			ap.setSize(size);
			
			Apple_PojoCheck apChk = new Apple_PojoCheck();
			
			
			apChk.setCheck(ap);
			apChk.printCheck();
			
			break;
		}
		
		
		
		
		
		
	}
}
