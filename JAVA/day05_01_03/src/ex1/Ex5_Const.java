package ex1;

public class Ex5_Const {
	public Ex5_Const() {
		this("test");  //1.�⺻ �����ڸ� �����Ϸ� �Դ��� String �Ű������� ���� ������ ȣ��
		System.out.println("aa");
	}
	public Ex5_Const(String msg) {
		this(true);		//2.boolean �Ű������� ���� ������ ȣ��
		System.out.println("bb");
	}
	public Ex5_Const(float f) {
		this(10);		//4.int �Ű������� ���� ������ ȣ��
		System.out.println("cc");
	}
	public Ex5_Const(int n) {
						//5. ����.
		System.out.println("dd");
	}
	public Ex5_Const(boolean b) {
		this(3.14f);	//3.float �Ű������� ���� ������ ȣ��
		System.out.println("ee");
	}
	
	public static void main(String[] args) {
		new Ex5_Const(); //�⺻ ������ ȣ��
		
	}
}
