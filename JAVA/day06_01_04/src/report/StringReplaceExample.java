package report;

public class StringReplaceExample {
	public static void main(String[] args) {
		//replace()메소드는 첫 번째 매개값인 문자열을 찾아 두번째 매개값인 문자열로 대치한 새로운 문자열을 생성하고 리턴한다.
		//메모리 공간안에 값을 수정해서 그곳에 저장하는게 아니라 새로운 메모리공간에 대체된 문자열이 저장된다.
		
		
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바", "JAVA"); 
		System.out.println(oldStr);
		System.out.println(newStr); //자바가 JAVA로 변경되어 출력
		
	
	}
}
