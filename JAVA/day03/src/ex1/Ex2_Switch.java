package ex1;

public class Ex2_Switch {
	public static void main(String[] args) {
		
		String s = "B";
		boolean b = true; 	//�Ұ�
		char ch = 'A';
		float f = 3.14F;	//�Ұ�
		byte bb =10;
		double bn = 10.1; 	//�Ұ�
		long ll = 10L;		//�Ұ�
		
		//s = ""+ch;
		
		switch(s) {
		case "A":
			System.out.println("���ڿ� A");
			break;
		case "B":
			System.out.println("���ڿ� B");
			break;
		default:
			System.out.println("���� ���ڿ�!");
		}
		
		switch(ch) {
		case 'A':
			System.out.println("����A");
			break;
		case 'B':
			System.out.println("����B");
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

