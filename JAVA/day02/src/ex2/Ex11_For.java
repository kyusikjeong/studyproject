package ex2;

public class Ex11_For {
	public static void main(String[] args) {
		String msg = "";//문자열 변수를 초기화
		// 0부터 10까지 1씩 반복한다.
		for(int i=0; i<=10; i++) {
			//i의 홀수 인지 짝수인지를 조건을 판별
			if(i%2 ==0) {
				msg = "짝";
			} else {
				msg = "홀";
				
			}
			System.out.println(i+ " : "+msg);
		}
	}
}
