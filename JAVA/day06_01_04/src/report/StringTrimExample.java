package report;

public class StringTrimExample {
	//trim()메소드는 문자열의 앞뒤 공백을 제거한 새로운 문자열을 생성하고 리턴한다.
	//trim()메소드는 앞뒤의 공백만 제거할 뿐 중간의 공백은 제거하지 않는다.
	//trim()메소드 역시 기존의 메모리 주소에 있는 값의 공백을 제거하는게 아니고 새로운 주소값에 공백을 제거한 값을 생성한다.
	
	public static void main(String[] args) {
		String tel1 = " 02";
		String tel2 = "123  ";
		String tel3 = "   12 34   ";  //중간의 공백은 제거되지 않는걸 확인가능
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);  //0212312 34 출력
		
	}
}
