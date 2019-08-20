package report;

public class ByteToStringExampale {
	public static void main(String[] args) {
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes); 
		//입력한 bytes 배열을 문자열로 변환한다.
		//즉,배열 내부에 입력한 값과 일치하는 코드에 해당하는 문자열이 출력되게 된다. (Editplus에서 확인했던 내용)
		System.out.println(str1);
		//Hello Java 출력
		
		String str2 = new String(bytes, 6,4);
		//bytes 배열안에 7번째에 해당하는(0부터 시작하므로) 74 부터 97까지에 해당하는 문자열이 출력된다. 
		System.out.println(str2);
		//JAVA 출력
	}
}
