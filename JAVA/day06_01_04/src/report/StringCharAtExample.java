package report;

public class StringCharAtExample {
	public static void main(String[] args) {
		String subject = "자바 프로그래밍";
		char charValue = subject.charAt(3); //매개값으로 주어진 인덱스의 문자를 리턴.
		                      //프 가 찍힌다.	//여기서 인덱스란 0에서부터 "문자열길이-1"까지의 번호
		
		String ssn = "010624-3230123";
		char sex = ssn.charAt(7);  //0번부터이므로 주민등록번호로 입력한 값의 두번째 단락 첫번째자리를 읽고 값을 출력한다.
		switch (sex) {			   //switch 문을 통해 남녀를 구분한다. 해당 예제에서는 남자입니다 가 출력된다.
		case '1':
			System.out.println("옛날 남자사람 입니다.");
			break;
		case '3':
			System.out.println("남자 입니다.");
			break;
		case '2':
			System.out.println("옛날 여자사람 입니다.");
			break;
		case '4':
			System.out.println("여자 입니다.");
			break;
		}
		
	}
}
