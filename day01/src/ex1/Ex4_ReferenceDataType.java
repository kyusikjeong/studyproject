package ex1;

public class Ex4_ReferenceDataType {
	public static void main(String[] args) {
		//���ڿ� , �̿ܿ� ��ü�� �����ϴ� �ڷ���
		// ""=> ���ڿ� ���� ������ ������ �ڷ��� String
		System.out.println("�ȳ��ϼ���");
		System.out.println(10);
		int num1 = 10;
		System.out.println(num1);
		//String ���ڿ� �����ڷ��� ������ ����
		String str;
		//������ �����ʹ� �������.
		str = "asdfasdfasdfasdfasfd";
		System.out.println(str);
		str = "     hi";//���鵵 ���ڿ��� �ν�
		System.out.println(str);
		System.out.println(str.length());
		str = "hi"+"one";  //���ڿ�+���ڿ� = > ������ �ǹ�
		str = "hi"+10; //���ڿ�+���ڿ� == > ���ڿ�
		str = true +"hi";
		System.out.println(str);
		//str = 100+200; ������ �������̹Ƿ� ������ �߻��Ѵ�.
		//String Ŭ���� :  �ڹ� API���� �������ִ� Ŭ����
		// ���ڿ��� ������ �� �ִ� char���� �迭�� ������ �Ǿ� �ִ�.
		// ������ �׳ɹ��ڿ��� �����ϴ� �����ڷ������� �������.
		
	}
}
