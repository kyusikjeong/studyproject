package exam1;

import java.util.Scanner;

public class Exam_ExamFor {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("단 입력 : ");
		int gNum = Integer.parseInt(s.nextLine());
		
		System.out.print("범위 입력 (3,5,7) : ");
		int rNum = Integer.parseInt(s.nextLine());
		int rNum1 = rNum/2;
		
		for(int i = 0;i<=9;i++) {
			for(int  j=gNum-rNum1; j<= gNum+rNum1; j++) {
				if (i ==0)
				{
					System.out.print(j+"단\t");
				} else {
					System.out.print(j+"*"+i+"="+j*i+"  ");
				}
				
			}
			System.out.println("");
		}
	}
}
