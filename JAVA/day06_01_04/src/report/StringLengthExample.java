package report;

public class StringLengthExample {
	public static void main(String[] args) {
		
		//length()�޼ҵ�� ���ڿ��� ����(������ ��,��������) �� �����Ѵ�. 
		String ssn = "7306241230123";  //13��
		int length = ssn.length();
		if(length == 13) {
			System.out.println("�ֹι�ȣ �ڸ����� �½��ϴ�");  //�ڸ����� ��ġ�ϹǷ� �ش� ����� ���
			
		} else {
			System.out.println("�ֹι�ȣ �ڸ����� Ʋ���ϴ�.");
		}
		
	}
}
