package report;

public class StringIndexOfExample {
	public static void main(String[] args) {
		
		//indexOf()�޼ҵ�� �Ű������� �־��� ���ڿ��� ���۵Ǵ� �ε����� �����ϸ�
		//�־��� ���ڿ��� ������ -1 �� �����Ѵ�.
		String subject = "�ڹ� ���α׷���";
		
		int location = subject.indexOf("���α׷���");
		System.out.println(location);  //3�� ���ϵ�.
		
		if(subject.indexOf("�ڹ�") != -1) { // -1�� �Է��� ���ڿ��� ������ ���ϵǴ� ���̹Ƿ� �ݴ�� ������ true...
			System.out.println("�ڹٿ� ���õ� å�̱���");
			
		} else {
			System.out.println("�ڹٿ� ���þ��� å�̱���");
		}
	}
}
