package exam1;

import java.util.Scanner;

public class Ex3_AppleBucket {
//�ٱ��� �ִ� ������ 10��. 10���� �ʰ��ϸ� �ʰ��Ѱ����� �ؿ� ������ش�.
	public static void main(String[] args) {
		
		
		exam();
	}
	public static void exam() {
		//���� �����ڸ� ����ؼ� �ٱ����� ���� ���Ѵ�.
		Scanner sc = new Scanner(System.in);
		System.out.print("����� ������ �Է��ϼ��� :");
		int app = Integer.parseInt(sc.nextLine());
		
		int basket = 10;
		int maxBasket = 10;
		int basketNum = app / maxBasket+ (app% maxBasket == 0 ? 0:1);
	
		
		
		if (basketNum>maxBasket) {
			System.out.println("�ٱ����� ���� �ʰ��Ǿ����ϴ�. �ٱ����� ������ �ִ� 10�� �Դϴ�.");
			System.out.println("*****************************");
			System.out.println("�ʿ��� �ٱ����� ��: "+ basketNum);
		} else {
			System.out.println("�ٱ����� ����: "+ basketNum);
		}
		// int basket number = app /  maxBasket+(app % maxBasket == 0? 0:1);
		
		
	}
}
