package report;

public class StringValueOfExample {
	public static void main(String[] args) {
		
		//valueOf메소드는 기본타입의 값을 문자열로 변환하는 기능을 가지고 있다. 
		
		//String 클래스에 타입별로 오버로딩 되어있는 메소드들.
		//static String valueOf(boolean b)
		//static String valueOf(char c)
		//static String valueOf(int i)
		//static String valueOf(long l)
		//static String valueOf(double d)
		//static String valueOf(float f)
		
		String str1 = String.valueOf(10); //valueOf 메소드를 통해 문자열로 변환되어 String타입 변수에 저장된다.
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1); 
		System.out.println(str2);
		System.out.println(str3);
		
	}
}
