package ex1;
//�͸��� ���� �ּҰ� ���� ��ü�� �����ϴ� ���� �ǹ� �ϴµ�
//�͸� ���� Ŭ������ �������̽�, �߻�Ŭ������ new �����ڷ� ������ �� ����
//�͸� ���� Ŭ������ ������ �� �ڿ��� ȣ���ϴ� �����̴�.
//�׿ܿ� �Ϲ� Ŭ������ �͸� ���� Ŭ������ ���� ����� �� �ִ�.

public class Ex4_Anon {
	//����������� �͸� ����Ŭ������ ����
	MyTest test = new MyTest() { //�������̽��� ��ü������ �ȵ����� new�� ����ؼ� ������ �����ν� �޸� �ּҿ� ���� �Ҵ��ų�� �ִ�
		//�׷��� test�� ���������� ���� �޸��ּҿ� ������ printData()�� �����ؼ� ����� �� �ְ� �ȴ�.
		@Override
		public void printData() {
			System.out.println("data2: "+data);
		}
	};
	
	public Ex4_Anon() {
		test.printData();
	}
	
	public void mytest() {
		//���� ����Ŭ���� �������� ����� ��
		new MyTest() {
			@Override
			public void printData() {
				System.out.println("data : "+data);
			}
		}.printData();
	}
	
	public static void main(String[] args) {
		//�����ڷ��� , �������� �ٷ� ������ �޼��� ȣ��
		//new Ex4_Anon().mytest();
		Ex4_Anon ref = new Ex4_Anon();
		ref.mytest();
	}
}
