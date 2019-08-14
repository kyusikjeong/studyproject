package exam1;

import java.util.Scanner;

public class Ex4_ExamIF01_MAX {
	public static void main(String[] args) {
		exam();
	}
	
	public static void exam() {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("num1 : ");
		int num1 = Integer.parseInt(s.nextLine());
		System.out.print("num2 : ");
		int num2 = Integer.parseInt(s.nextLine());
		System.out.print("num3 : ");
		int num3 = Integer.parseInt(s.nextLine());
		
		int numMax =0;
		
		if (num1 >= num2 ) {
			numMax = num1;
		} else if (num2 >= num1) {
			numMax = num2;
			
		}
		
		if (num3 >=numMax) {
			numMax = num3;
		} 
		// if를 두번만 써서 구현.
		// int max = num1; 이런식으로.
		System.out.println("최대값 : "+numMax);
	}
}
