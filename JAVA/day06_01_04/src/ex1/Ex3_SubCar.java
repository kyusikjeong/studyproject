package ex1;

public class Ex3_SubCar extends Ex3_SuperCar{
	
	public void testsub() {
		System.out.println("�ڽ� Ŭ������ �޼��� ȣ��");
		
	}

	@Override //������̼�. ���డ���� �ּ��̶�� �͸� ����ϰ� �Ѿ��.
	public void carColor() {
		//super �θ�Ŭ������ �ּ�
		//super.carColor();
		System.out.println("�÷� ���� : �Ķ���");
	}
	
	public static void main(String[] args) {
		//�θ� ���� �ڷ������� �ڽ� Ŭ������ ��ü�� ����
		//�θ��� �ڿ��� ������ �����ϰ�
		//�ڽ� ��ü�� Ex3_SubCar() �ڿ��� ������ �Ұ����ϴ�.
		
		Ex3_SuperCar ref = new Ex3_SubCar();
		System.out.println(ref instanceof Ex3_SubCar);
		ref.carColor();
		ref.testSuper();
		//ref.testsub(); // -> �����ڷ����� �θ�Ŭ�����̱� ������
		//������ �� ����. (but ������ �Ǿ�����....)
		
	}
	
}
