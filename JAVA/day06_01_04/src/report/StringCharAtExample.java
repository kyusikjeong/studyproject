package report;

public class StringCharAtExample {
	public static void main(String[] args) {
		String subject = "�ڹ� ���α׷���";
		char charValue = subject.charAt(3); //�Ű������� �־��� �ε����� ���ڸ� ����.
		                      //�� �� ������.	//���⼭ �ε����� 0�������� "���ڿ�����-1"������ ��ȣ
		
		String ssn = "010624-3230123";
		char sex = ssn.charAt(7);  //0�������̹Ƿ� �ֹε�Ϲ�ȣ�� �Է��� ���� �ι�° �ܶ� ù��°�ڸ��� �а� ���� ����Ѵ�.
		switch (sex) {			   //switch ���� ���� ���ฦ �����Ѵ�. �ش� ���������� �����Դϴ� �� ��µȴ�.
		case '1':
			System.out.println("���� ���ڻ�� �Դϴ�.");
			break;
		case '3':
			System.out.println("���� �Դϴ�.");
			break;
		case '2':
			System.out.println("���� ���ڻ�� �Դϴ�.");
			break;
		case '4':
			System.out.println("���� �Դϴ�.");
			break;
		}
		
	}
}
