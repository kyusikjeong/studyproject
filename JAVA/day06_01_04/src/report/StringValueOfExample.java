package report;

public class StringValueOfExample {
	public static void main(String[] args) {
		
		//valueOf�޼ҵ�� �⺻Ÿ���� ���� ���ڿ��� ��ȯ�ϴ� ����� ������ �ִ�. 
		
		//String Ŭ������ Ÿ�Ժ��� �����ε� �Ǿ��ִ� �޼ҵ��.
		//static String valueOf(boolean b)
		//static String valueOf(char c)
		//static String valueOf(int i)
		//static String valueOf(long l)
		//static String valueOf(double d)
		//static String valueOf(float f)
		
		String str1 = String.valueOf(10); //valueOf �޼ҵ带 ���� ���ڿ��� ��ȯ�Ǿ� StringŸ�� ������ ����ȴ�.
		String str2 = String.valueOf(10.5);
		String str3 = String.valueOf(true);
		
		System.out.println(str1); 
		System.out.println(str2);
		System.out.println(str3);
		
	}
}
