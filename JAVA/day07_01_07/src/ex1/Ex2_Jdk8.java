package ex1;

public interface Ex2_Jdk8 {
	public int num2 = 20;//���
	public void num1(); //�߻� �޼���
	//jdk8 ���� ����, static �޼���
	
	public static void test() {
		System.out.println("static Test");
	}
	
	//default �޼���
	default public String test2() {
		return "���� ������� ������� ���̷�";
		//System.out.println("�⺻ ��");
	}
	default public void name() {
		System.out.println("default �޼ҵ�");
	}
	
}
