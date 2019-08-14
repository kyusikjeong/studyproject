package ex1;

public class Ex1_Oper {
	public static void main(String[] args) {
		//일반 자료형일 경우 대입 연산자
		int a = 0;
		a += 10;
		System.out.println("1) "+(a -=5));
		System.out.println("2) "+(a *=10));
		System.out.println("3) "+(a /=2));
		System.out.println("4) "+(a %=2));
		
		//String 클래스는 불변적인 특징이 있기 때문에 += 연산하면 생성된 문자열 객체를 가비지 컬렉션이 모두 제거하는
		//불필요한 메모리가 낭비됨! => 자료형에서는 이정도만 이해(클래스와 객체)
		
		String msg = "ABC";
		msg += "DEF";
		msg += "ZZZ";
		
		System.out.println(msg);
		//Buffer 란 개념을 사용해 문자열을 안전하게 저장해서 (append() 호출해서 버퍼에 저장)
		//사용할 수 있다.
		StringBuffer sb = new StringBuffer();
		sb.append("ABC").append("DEF").append("ZZZ");
		System.out.println(sb);
		
	}
}
