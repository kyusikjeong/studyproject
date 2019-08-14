package ex1;

public class Ex2_Variable {
	public static void main(String[] args) {
		//변수 구분 : 기본형 타입(8가지), 참조타입(그외)
		//복습 포인트) 교재:38page!
		//1)변수를 선언하고 저장하는 방법 ***********************
		
		
		int a =3; //변수 선언. 3이란 정수를 (= 대입연산자) 대입한다
		int b; //변수를 선언, 값은 할당이 안된 상태;
		b = 3; //선언한 변수 b에 3을 대입
		//int a; 변수는 {} 영역 안에서 한번만 선언할 수 있다.
		// short 타입의 c 값에는 50을 저장 할 수 있습니다.
		short c = 50;
		// byte 타입의 d 에는 100값을 저장 할 수 있습니다. -128~127 범위
		byte d = 100;
		//All 값을 문자열로 모니터로 출력을 하는 함수
		
		//2)저장한 변수를 출력하는 방법 ***********************
		System.out.print("변수 a의 값 :");
		System.out.println(a);
		System.out.println("----------------------------");
		//=> 문자열을 의미하고 참조 자료형으로 생각
		// 문자열 연결 연산자+
		System.out.println("변수 b의 값 : "+b);
		
		System.out.println("변수 c의 값 :"+c);
		
		System.out.println("변수 d의 값 :"+d);
		long e = 12345678990L; //L ~ l 리터럴 접미사.
		System.out.println(e);
		//예) long형 8byte -> int 4byte 형으로 강제로 형을 변환
		// int형의 자료형의 범위를 넘어서는 값이라면 오버플로어가 발생해서 정확한 값이 안나온다.
		int times = (int) System.currentTimeMillis();//밀리초 단위의 현재시간을 리턴
		System.out.println("Times : "+times);
		
		//3) 변수 명명규칙
		//1. 대소문자 구분을 한다. 길이의 제한이 없다.
		//2. 숫자로 시작하면 안된다.
		//3. 특수문자 _ , $ 두가지만 가능하다.
		//4. 예약어는 변수명으로 사용 불가.
		//5. 변수는 무조건 소문자로 시작해야 한다.(필수)
		int x;
		int X;//대소문자 구분
		int numberOptionApplication; //소문자로 시작 대문자와 의미대로 혼용
		
		//4)  변수와 상수의 차이
		//숫자로 시작은 안되지만 혼용은 가능
		int num1; //가능
		int num2 = 10;
		System.out.println(num2); //10
		num2 = 20;//마지막에 저장된 값만 기억합니다.
		System.out.println(num2); //20
		
		//변수 : 변하는 수.
		//상수 : 일정한 수. final 키워드를 사용하면 프로그램이 종료시까지 변경이 불가능.
		final int SIZE=8;
		System.out.println("final int : "+SIZE);
		//3.14 = > double 이고, float(4) = > F,f 리터럴 표기
		//5).실수형, 문자, 논리
		float g = 3.14f;
		double h = 3.14d;//double, 3.14d 가능
		//boolean(1)
		boolean i = true;
		// 자바에서는 한문자를 유니코드(2 byte)로 인식
		// '문자' => "A"는 문자열(참조자료형)
		char j = 'A';
		
		System.out.println("boolean: "+i + " \nchar :"+ j);
		//int k = 100L; 맞지 않는 데이터타입을 넣었을때 경고를 띄워주는건 개발자가 상황을 인지하게 하기 위함.
		
		
	}

}
