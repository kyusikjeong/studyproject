package ex1;

public class Ex1_Imple implements Ex1_Inter{

	@Override
	public void test() {
		System.out.println("�������̽� ��� ��:"+num1);
		
	}

	@Override
	public void test2() {
		System.out.println("�������̽� ��� ��:"+num2);
		
	}
	
	public static void main(String[] args) {
		//�������̽��� ���� �ڷ������� ���� Ŭ������ ��ü�� ����
		Ex1_Inter ref = new Ex1_Imple();
		
		ref.test();
		ref.test2();
	}
	
}
