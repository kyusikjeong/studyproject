package ex2;

public class Ex11_For {
	public static void main(String[] args) {
		String msg = "";//���ڿ� ������ �ʱ�ȭ
		// 0���� 10���� 1�� �ݺ��Ѵ�.
		for(int i=0; i<=10; i++) {
			//i�� Ȧ�� ���� ¦�������� ������ �Ǻ�
			if(i%2 ==0) {
				msg = "¦";
			} else {
				msg = "Ȧ";
				
			}
			System.out.println(i+ " : "+msg);
		}
	}
}
