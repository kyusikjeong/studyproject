package ex1;

public class Ex3_Const {
	private String msg;
	//1.����ڰ� ������ �����ڰ� �ϳ��� �������
	//�����Ϸ��� ������ �� �⺻ �����ڸ� ���Ƿ� ������ش�.**********
	//2.�����ڵ� �����ε� ����.
	//�⺻ ������ ����
	
	public Ex3_Const() {
		//�����ϴ� �������� ���� - �ʱ�ȭ
		System.out.println("�ʱ�ȭ �Ǿ����ϴ�.");
		msg = "hello";
	} 
	
	//3.�⺻ �����ڰ� �ƴ� ���ڰ��� �ִ� ������ �����ϴ� ��쿣 
	//�����Ϸ��� <�⺻ ������>�� ����� ���� ����**********
	//������ �����ε�.�⺻
	public Ex3_Const(String str) {
		System.out.println("���ڸ� ���ڷ� ���� ������ ȣ��"+str);
	}
	
	
	//�����ڸ� ����ϴ� ����: ��üȭ �� �� �ڿ��� �ʱ�ȭ �ϴ� ����
	
	public void print() {
		System.out.println(msg);
		
	}
	public void print(String str) {
		msg = str;
		System.out.println(msg);
		
	}
	public static void main(String[] args) {
		//������ ȣ�� Ex3_Const(): �⺻ ������
		Ex3_Const ref = new Ex3_Const("Test");
		ref.print();
		ref.print("tt");
		
	}
}
