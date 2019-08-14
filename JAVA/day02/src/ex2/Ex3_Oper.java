package ex2;

public class Ex3_Oper {
	public static void main(String[] args) {
		//증감연산자
		//전치 : 증가부터 시켜놓고 실행
		//후치 : 실행한 후 증가 시키는것
		int a = 10;
		int b = 10;
		int c = 0;
		
		System.out.println("a: "+(++a));
		System.out.println("b: "+(b++));
		System.out.println("b++ :"+b);
		System.out.println("c: "+(c++));
		System.out.println("c: "+c);
		
		int e = 1;
		System.out.println(e++);
		System.out.println(++e);
	}
}
