package ex1;

public class Ex3_StaticInnerMain {
	public static void main(String[] args) {
		//static �� �������� ��� �����ϴ�.
		//���� ��ü�� �����ؼ� ����(����)�ϴ��� static ������ ���� �ϳ���.
		//static �� ������ �ܺ� Ŭ����.static �ڿ�
		//�ܺ� Ŭ����.this ó��.
		
		Ex3_StaticInner.Inner.printData();
		System.out.println("-----------------");
		//printData2 ȣ���غ���
		
		new Ex3_StaticInner().Inner().printData2();
		Ex3_StaticInner.Inner ref = new Ex3_StaticInner().Inner();
		ref.printData2();
	}
}
