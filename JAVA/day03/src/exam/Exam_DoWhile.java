package exam;

public class Exam_DoWhile {
	//do while 문 사용하여 10부터 0까지 카운트다운
	
	public static void main(String[] args) throws InterruptedException { //Thread 쓰는데 필요한 exception 선언
		int i = 10;
		do {
			System.out.println("새해 카운트다운 "+i);
			//1초씩 잠시 프로그램을 멈추는 기능을 한다.
			Thread.sleep(1000); //Thread 는  java.lang 패키지에 존재한다.
			i--;
		} while (i>=0);  
		System.out.println("************************");
		System.out.println("Happy new Year!");
		
	}
}
