package ex1;

public class Ex2_DefaultImple implements Ex2_Jdk8{
	//������ ������ �Ǵ� ���� �߻�޼���
	@Override
	public void num1() {
		System.out.println("������ ����� �Ế�ô�.");
		System.out.println("------------------");
		System.out.println(test2());
		System.out.println("------------------");
		//interface �� ������ �ִ� static �޼��嵵 ȣ���غ��ô�.
	}

	public static void main(String[] args) {
		Ex2_Jdk8 ref = new Ex2_DefaultImple();
		ref.num1();
		ref.test2();
	}
}
