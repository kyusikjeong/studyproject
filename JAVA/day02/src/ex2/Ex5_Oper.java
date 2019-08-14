package ex2;

public class Ex5_Oper {
	public static void main(String[] args) {
		int a = 12;		//0 0 0 0 1 1 0 0 
		int b = 2;		//0 0 0 0 0 0 1 1
		//a: 비트 연산할 변수, b: 얼마나 쉬프트 할 것인지
		//b만큼 쉬프트 연산하라
		int c = a >> b;
		System.out.println("12>>2 :"+c);
		
	}
}
