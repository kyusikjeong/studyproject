package report;

public class StringToLowerUpperCaseExample {
	public static void main(String[] args) {
		//toLowerCase()메소드는 문자열을 모두 소문자로 바꾼 새로운 문자열을 생성한 후 리턴한다.
		//반대로 toUpperCase()메소드는 문자열을 모두 대문자로 바꿔준뒤 리턴한다.
		//이 역시 기존 메모리영역의 값을 수정하는게 아니고 다른 메모리 영역에 변경된 값이 새로 저장된다.
		

		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		//String upperStr1 = str1.toUpperCase(); //대문자로 변경됨.
		System.out.println(str1.equals(str2));  //대소문자가 다르므로 false
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
	
	

		System.out.println(lowerStr1.equals(lowerStr2)); //둘 다 소문자로 바뀌어서 true 
		
		
		//equalsIgnoreCase() 메소드를 사용하면 대소문자로 변경하는 작업을 생략하고 두 문자열을 비교한다.
		System.out.println(str1.equalsIgnoreCase(str2)); //true
		
		
	}
}
