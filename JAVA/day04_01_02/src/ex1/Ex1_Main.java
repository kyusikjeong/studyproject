package ex1;

public class Ex1_Main {
	public static void main(String[] args) {
		//�̹� ����� Ex1_ClasseDemo�� ��ü�� �����ϴ� ����� �˰� �־��.
		Ex1_ClassDemo ref = new Ex1_ClassDemo();
		//������ . �����ڸ� ����ؼ� ����մϴ�.
		ref.pay = 10000; //������ Ex1_ClassDemo�� �ּ�(100)���� �����ؼ� ���� pay�� ���� 10000���� ���
		System.out.println("ref.pay = "+ref.pay);
		
		ref.team = "test";
		System.out.println("ref.team = "+ref.team);
		//Ex1_ClassDemo �� ������ �ִ¤��ʵ�ȿ��� team�̶� �Ӽ��� ������ ���� �����ϰ� ����غ��ô�.
		
	}
}
