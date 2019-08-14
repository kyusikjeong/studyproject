package ex1;

public class Ex3_Demotion {
	//4byte 이하의 연산은 JVM 연산시 자동으로 4byte 로 승격해서 연산함
	//demotion, promotion
	//java Ex3_Demotion => JVM이 실행 시 main 메서드를 실행
	public static void main(String[] args) {
		//변수 선언
		byte num1 = 10;
		byte num2 = 20;
		//System.out.println("num1 : "+num1+ "\nnum2 : "+num2);
		//byte num3 = num1+num2;  //4byte 이하의 연산이므로 승격되서 다운캐스팅 하라는 오류가 발생. demotion 발생. 
		byte num3 = (byte) (num1+num2);
		System.out.println("num3 = "+num3);
		
		//연습)short sh1, sh2에 값을 각각 100,200을 대입
		//short sh3에 값을 저장한 후에 출력을 해봅시다.
		short sh1 = 100;
		short sh2 = 200;
		short sh3 = (short)(sh1+sh2);
		System.out.println("sh3 : "+sh3);
		
		char c1 = 'A';//65
		short c2 = 1;
		//char c3 = c1+c2 // 데이터타입이 일치하지 않을때 캐스팅을 해주어야 연산이 가능하므로 에러발생. 
		char c3 = (char) (c1+c2);
		System.out.println(c3);
		//위의 예제는 4byte 이하의 연산이므로 demotion 발생.
		
	}
}
