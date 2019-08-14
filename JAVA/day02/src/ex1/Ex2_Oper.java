package ex1;

public class Ex2_Oper {
	public static void main(String[] args) {
		//논리연산자: && 논리곱, || 논리합, ! 부정
		//true && true -> true / false && true 일때 true 는 실행되지 않는다.
		//|| 는 false || true 가 되더라도 true 까지 실행한다.
		int a = 10;
		int b = 20;
		boolean c = ((a +=12)> b) || (a == (b+=2)); //앞의 조건이 true 이므로 뒤의 연산은 실행되지 않는다.
		System.out.println("c= "+c);
		System.out.println("a= "+a);
		System.out.println("b= "+b); 
		System.out.println("--------------------");
		
	}
}
