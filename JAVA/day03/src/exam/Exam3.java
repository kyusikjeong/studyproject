package exam;

import java.util.Scanner;

public class Exam3 {
	public static void main(String[] args) {
		int i = 1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("���� :");
		int range = Integer.parseInt(sc.nextLine());
		System.out.println("���� :");
		int limit = Integer.parseInt(sc.nextLine());
		
		
		do {
			System.out.print(i+" ");
			
			if (i % range ==0) {
				System.out.println("");
			}
			i++;
		}while (i<=limit);
	}
}
