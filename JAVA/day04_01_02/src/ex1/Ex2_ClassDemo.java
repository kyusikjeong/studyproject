package ex1;
//Ŭ���� ����
//1.���
//2.����ʵ�
//3.����޼���
//Ŭ������ ��ü�������� ����(����),��� ���θ޼���� ���Ե��� �ʴ´�.

public class Ex2_ClassDemo {
	//******** ����ʵ�� ����� ���ÿ� �ʱ�ȭ ��!
	int pay;
	String team;
	
	//�޼��带 �ѹ� �����(����)���鼭 �ǹ̸� �ľ��غ���.
	//public static void main(String[] args) {
	public void test() {// Ex2_ClassDemoŬ������ ��ü�� ������ ����. ����޼���
		System.out.println("Pay : "+pay+", Team : "+team);
	}
	//�׽�Ʈ �� 18~21 �ּ� ó���ϰ� Ex2_Main ����� ������
	/*
	 * public static void main(String[] args) { Ex2_ClassDemo ref = new
	 * Ex2_ClassDemo(); ref.test();
	 * 
	 * }
	 */
	
	//�ǹ��ִ� �۾����� �޼��带 ���� �غ��ô�.
	//pay �� � ���� ������ �� �ֵ��� �����ϴ� �޼���  �����
	//��ȯ���� ������ �� ����ؾ� �� ��: �޼��� ȣ�� �Ŀ� Ư�� ���� ��ȯ ���� ������
	//���� ���� ������ �޼��常 ������ ������.
	//���� �ִ� �۾��� ���ؼ� ��ȯ���� ���� �ʿ䰡 ���ٰ� �����ϸ� void�� ���ָ� �ȴ�.
	
	public void insertPay(int p) {//���� ����
		pay = p;
		System.out.println("LOG1 : �������� pay: "+p); //���������� ���������� �̸��� �������� ���������� �켱������ ����
		System.out.println("LOG2 : ����ʵ� pay: "+pay); //���������� ������ ���� �ȿ����� ����� �����ϴٴ°��� �� ����Ұ�
		
		//1.team�� ���� �����ϴ� �޼��带 �����.
		//2.pay, team �� ���� ���ÿ� �����ϴ� �޼��� �����
		
	}
	
	public void setTeam(String tname) {
		team = tname;
		
	}
	
	public void setValue(int p , String tname) {
		pay = p;
		team = tname;
	}

}
