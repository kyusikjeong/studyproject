package ex2;

public class Ex8_Ifelse {
	public static void main(String[] args) {
		String str1 = "Test";//������ �ʱ�ȭ
		String str2 = "Test";
		
		if(str1 == str2) { //
			System.out.println("str1, str2�� �ּҰ� ����.");
		}else {
			System.out.println("str1, str2�� �ּҰ� �ٸ���.");
		}
		  //str1,str2 �� new�� ����ؼ� ���� ���� �����Ǿ���.
		  // String��ü�� �����Ͱ� �񱳴� equals �޼ҵ带 �̿��ؼ� ���Ѵ�.
		if(str1.equals(str2)) {
			System.out.println("str1, str2�� �ּҰ� ����.");
		}else {
			System.out.println("str1, str2�� �ּҰ� �ٸ���.");
		}
	}
}
