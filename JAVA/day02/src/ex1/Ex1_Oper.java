package ex1;

public class Ex1_Oper {
	public static void main(String[] args) {
		//�Ϲ� �ڷ����� ��� ���� ������
		int a = 0;
		a += 10;
		System.out.println("1) "+(a -=5));
		System.out.println("2) "+(a *=10));
		System.out.println("3) "+(a /=2));
		System.out.println("4) "+(a %=2));
		
		//String Ŭ������ �Һ����� Ư¡�� �ֱ� ������ += �����ϸ� ������ ���ڿ� ��ü�� ������ �÷����� ��� �����ϴ�
		//���ʿ��� �޸𸮰� �����! => �ڷ��������� �������� ����(Ŭ������ ��ü)
		
		String msg = "ABC";
		msg += "DEF";
		msg += "ZZZ";
		
		System.out.println(msg);
		//Buffer �� ������ ����� ���ڿ��� �����ϰ� �����ؼ� (append() ȣ���ؼ� ���ۿ� ����)
		//����� �� �ִ�.
		StringBuffer sb = new StringBuffer();
		sb.append("ABC").append("DEF").append("ZZZ");
		System.out.println(sb);
		
	}
}
