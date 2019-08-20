package report;

public class StringLengthExample {
	public static void main(String[] args) {
		
		//length()메소드는 문자열의 길이(문자의 수,공백포함) 를 리턴한다. 
		String ssn = "7306241230123";  //13개
		int length = ssn.length();
		if(length == 13) {
			System.out.println("주민번호 자리수가 맞습니다");  //자릿수가 일치하므로 해당 결과가 출력
			
		} else {
			System.out.println("주민번호 자리수가 틀립니다.");
		}
		
	}
}
