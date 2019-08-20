package report;

public class StringSubstringExample {
	public static void main(String[] args) {
		//substring()메소드는 주어진 인덱스에서 문자열을 추출한다.
		//substring(int beginIndex,int endIndex)는 주어진 시작과 끝 인덱스 사이의 문자열을 추출한다.
		//substring(int beginIndex)는 주어진 인덱스부터 끝까지 문자열을 추출한다.
		
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0,6); 
		System.out.println(firstNum); //시작이 0이고 6번째인 - 사이의 문자열을 추출하므로 880815출력
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum); //7부터 끝까지 이므로 1234567 출력
	}
}
