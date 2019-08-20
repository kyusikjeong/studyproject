package ex1;

public class Ex2_Switch {
	public static void main(String[] args) {
		
		String s = "B";
		boolean b = true; 	//불가
		char ch = 'A';
		float f = 3.14F;	//불가
		byte bb =10;
		double bn = 10.1; 	//불가
		long ll = 10L;		//불가
		
		//s = ""+ch;
		
		switch(s) {
		case "A":
			System.out.println("문자열 A");
			break;
		case "B":
			System.out.println("문자열 B");
			break;
		default:
			System.out.println("없는 문자열!");
		}
		
		switch(ch) {
		case 'A':
			System.out.println("문자A");
			break;
		case 'B':
			System.out.println("문자B");
			break;
		}
		
		int num = 1;
		switch(num) {
			case 0:
				System.out.println("0");
				break;
			case 1:
				System.out.println("1");
				break;
		}
		
	}
}

