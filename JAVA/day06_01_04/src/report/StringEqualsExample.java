package report;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVar1 = new String("신민철");
		String strVar2 = "신민철";
		String strVar3 = "신민철";
		//자바는 문자열 리터럴이 동일하다면 동일한 String 객체를 참조하도록 되어있다.(묵시적 객체생성)
		//그러므로 strVar2와 strVar3은 동일한 String객체를 참조한다.
		//객체간의 문자열을 비교하고 싶다면 equals()메소드를 사용하면 된다.
		System.out.println((strVar1 == strVar2));  //false
		System.out.println((strVar2 == strVar3));  //true
		
		System.out.println(strVar1.equals(strVar2)); //true
		System.out.println(strVar2.equals(strVar3)); //true
		
		if(strVar1 == strVar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조"); //1은 new로 객체를 따로 생성했으므로 이쪽이 출력
		}
		
		if(strVar1.equals(strVar2)){
			System.out.println("같은 문자열을 가짐"); //문자열 리터럴을 비교시 같으므로 이쪽이 출력
		} else {
			System.out.println("다른 문자열을 가짐");
		}
	}
}
