package ex1;

public class Ex1_DoWhile {
	public static void main(String[] args) {
		int i = 0; //초기화
		do { //do while 문의 특징은 적어도 실행문의 실행이 한번은 보장된다는 것이다.
			if(i%2 ==0) {
				System.out.println("짝  :"+i);
			} else {
				System.out.println("홀 : "+i);
			}
			i++; //증감문
		} while( i<= 10); //조건식. 해당 조건이 true 면 계속 반복.
		
		System.out.println("-------------");
	}
}
