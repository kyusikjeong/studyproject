package ex1;

public class Ex3_ClassDemo {
	private int pay;
	//Ŭ�����ȿ� �Ӽ��� ������ ���ִ�.
	//���������� private ���
	///A ���̵� B���̵� pay�� �ڿ��� ���� �������� ���ϵ��� �Ѵ�.
	
	//this : ���� Ŭ������ �ּҸ� ����(�ڽ��� �ּҰ�)
	public void insertPay(int pay,String pwd) {
		//this.����ʵ��� pay = �������� pay
		if (pwd.equals("1")){
			this.pay = pay;
		} else {
			System.out.println("���޼���!");
		}
		
	}
	//����ʵ��� pay���� ��ȯ���ִ� �Լ�
	public int viewPay() {
		
		return pay;
	}
}
