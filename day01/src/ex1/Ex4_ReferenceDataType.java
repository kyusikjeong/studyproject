package ex1;

public class Ex4_ReferenceDataType {
	public static void main(String[] args) {
		//문자열 , 이외에 객체를 참조하는 자료형
		// ""=> 문자열 값을 저장할 변수의 자료형 String
		System.out.println("안녕하세요");
		System.out.println(10);
		int num1 = 10;
		System.out.println(num1);
		//String 문자열 참조자료형 변수를 선언
		String str;
		//글자의 갯수와는 상관없다.
		str = "asdfasdfasdfasdfasfd";
		System.out.println(str);
		str = "     hi";//공백도 문자열로 인식
		System.out.println(str);
		System.out.println(str.length());
		str = "hi"+"one";  //문자열+문자열 = > 연결을 의미
		str = "hi"+10; //문자열+비문자열 == > 문자열
		str = true +"hi";
		System.out.println(str);
		//str = 100+200; 정수형 데이터이므로 에러가 발생한다.
		//String 클래스 :  자바 API에서 제공해주는 클래스
		// 문자열을 저장할 수 있는 char형의 배열로 구성이 되어 있다.
		// 지금은 그냥문자열을 저장하는 참조자료형으로 기억하자.
		
	}
}
