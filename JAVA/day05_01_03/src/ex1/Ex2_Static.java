package ex1;

public class Ex2_Static {
	//  static �� ����. static ������� �������� ��밡��. �Ϲ� Ŭ������ �����ؾ� ��밡��
	//	���� �ϳ��� �����ؼ� ���� ��ü�� �����ؼ� ����� �� �ִ� �ڿ�
	//	static ������ ���� �ǰ� �ֱ� ������ �������� ���� �� ��� �ȴ� 
	//	static�� ������ ���� ��� �ڿ��� JVM�� ���� �߿� static������ ��ġ�Ѵ�
	
	public static int num1= 1; //static ����(����ʵ�)
	private int num2;		//�ν��Ͻ� ����(��� �ʵ�)
	public void startTest() {
		num1++;
		num2++;
	}
	
	public static int getNum1() { //static ������ static �޼ҵ�
		return num1;
		
	}
	public int getNum2() { //�ν��Ͻ� �޼ҵ�
		return num2;
	}
	
	public static void main(String[] args) {
		
	}
	
}
