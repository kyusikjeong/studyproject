package ex1;

public class Ex2_Main {
	public static void main(String[] args) {
		Ex2_Static ref1 = new Ex2_Static();
		Ex2_Static ref2 = new Ex2_Static();
		//�� ��ü�� �޼ҵ� ȣ��
		ref1.startTest(); //num1 - 1
		ref2.startTest(); //num1 - 2
		
		//��� a
		
		System.out.println("static num1:"+ ref1.getNum1());
		System.out.println("nun static num2:"+ref1.getNum2());
		System.out.println("------------------------------");
		System.out.println("static num1:"+ ref2.getNum1());
		System.out.println("nun static num2:"+ref2.getNum2());
		System.out.println(Ex2_Static.getNum1());
		System.out.println("���� ����   "+ Ex2_Static.num1); //static ����
		
		
	}
}
