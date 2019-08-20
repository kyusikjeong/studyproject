package report;

public class StringIndexOfExample {
	public static void main(String[] args) {
		
		//indexOf()메소드는 매개값으로 주어진 문자열이 시작되는 인덱스를 리턴하며
		//주어진 문자열이 없으면 -1 을 리턴한다.
		String subject = "자바 프로그래밍";
		
		int location = subject.indexOf("프로그래밍");
		System.out.println(location);  //3이 리턴됨.
		
		if(subject.indexOf("자바") != -1) { // -1은 입력한 문자열이 없을시 리턴되는 값이므로 반대는 있을시 true...
			System.out.println("자바와 관련된 책이군요");
			
		} else {
			System.out.println("자바와 관련없는 책이군요");
		}
	}
}
