package ex3;

public class Ex1_MemberInner extends SuperA{
	//�⺻ ���� ������
	int numA;
	//Ŭ���� ���ο����� ������ ����
	private int numB;
	private int numC;
	public Ex1_MemberInner() {
		numA = 10; numB = 100; numC = 200;
	}
	//��� ������ Ŭ������ ����: ��� ���� Ŭ����
	
	public class Inner extends SuperB{
		public void printData() {
			System.out.println("int A: "+numA);
			System.out.println("int B: "+numB);//���ٰ���
			System.out.println("int C: "+numC);
			
		}
	}
	
	public static void main(String[] args) {
		Ex1_MemberInner test = new Ex1_MemberInner();
		SuperB s = new SuperB();
		s.superB();
	}
}
