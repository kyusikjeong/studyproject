package ex1;

import java.util.Scanner;

public class Ex5_Oper1 {
	public static void main(String[] args) {
		//�� ������ : A,B �� ���ؼ� ������� boolean ���� ��ȯ
		//��� ������ : + - * / % �� �������
		Scanner sc = new Scanner(System.in);
		System.out.print("�� 1 :");
		int numA = Integer.parseInt(sc.nextLine());
		System.out.print("�� 2 :");
		int numB = Integer.parseInt(sc.nextLine());
		
		int resNum1 = numA + numB ;
		int resNum2 = numA * numB;
		int resNum3 = numA - numB;
		int resNum4 = numA / numB;
		int resNum5 = numA % numB;
		
		System.out.println(resNum1);
		System.out.println("+ ���� ���: "+resNum1);
		System.out.println("== ������: "+(numA == numB));
		
		System.out.println("* ���� ���: "+resNum2);
		
		System.out.println("!= ���� ���: "+(numA != numB));
		
		System.out.println("- ���� ���: "+resNum3);
		
		System.out.println("ũ��, ũ�ų� ����: " + (numA > numB)+","+(numA >=numB));
		
		System.out.println("�۴�, �۰ų� ����: " + (numA < numB)+","+(numA <= numB));
		
		System.out.println("/ ���� ���: "+resNum4);
		
		System.out.println("% ���� ���: "+resNum5);
	}
}
