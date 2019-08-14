package ex2;

public class Ex8_Ifelse {
	public static void main(String[] args) {
		String str1 = "Test";//묵시적 초기화
		String str2 = "Test";
		
		if(str1 == str2) { //
			System.out.println("str1, str2는 주소가 같다.");
		}else {
			System.out.println("str1, str2는 주소가 다르다.");
		}
		  //str1,str2 는 new를 사용해서 각각 힙에 생성되었음.
		  // String객체의 데이터값 비교는 equals 메소드를 이용해서 비교한다.
		if(str1.equals(str2)) {
			System.out.println("str1, str2는 주소가 같다.");
		}else {
			System.out.println("str1, str2는 주소가 다르다.");
		}
	}
}
