package ex2;

public class Ex7_If {
	public static void main(String[] args) {
		/*
		 * ���ǿ� �������� ���ϸ� If ���� ������� �ʴ´�.
		 * �׷��� else �� �����صθ� �� ���� ������ ��� �����ų �� �ִ�.
		 * if(����){���๮1:}else{���๮2:}
		 */
		int num = 10;
		int v;
		if (num ==10) {
			//�����Ϸ��� if ���� ������ �ȵ� ���� �ִٰ� �����ؼ� if���� �ʱ�ȭ �ϸ� ������.
			//���� else ���� �ʱ�ȭ �������. (����Ʈ��)
			v = 10;
			System.out.println(num+"���� ��");
		} else {
			v = 20;
			System.out.println(num+"���� ��");
		}
		
		System.out.println(v+"");
	}
}
