package ex3;


//Ex1_B �ڽ�Ŭ���� : �ڽ� extends �θ�Ŭ����
public class Ex1_B extends Ex1_A	{
	int bb = 2;
	public Ex1_B() {
		System.out.println("�ڽ� ������ ȣ��");
		
	}
	
	public static void main(String[] args) {
		//��� ���迡���� [�ڽ� Ŭ������ ��ü]�� �����Ѵ�.
		Ex1_B ref = new Ex1_B();
		//�θ�� �ڽ��� ������ �ȴ�
		System.out.println(ref.aa);
		System.out.println(ref.bb);
	}
}
