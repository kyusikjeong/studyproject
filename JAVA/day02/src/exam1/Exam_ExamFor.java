package exam1;

import java.util.Scanner;

public class Exam_ExamFor {
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		
		System.out.print("�� �Է� : ");
		int gNum = Integer.parseInt(s.nextLine());
		
		System.out.print("���� �Է� (3,5,7) : ");
		int rNum = Integer.parseInt(s.nextLine());
		int rNum1 = rNum/2;
		
		for(int i = 0;i<=9;i++) {
			for(int  j=gNum-rNum1; j<= gNum+rNum1; j++) {
				if (i ==0)
				{
					System.out.print(j+"��\t");
				} else {
					System.out.print(j+"*"+i+"="+j*i+"  ");
				}
				
			}
			System.out.println("");
		}
	}
}
