package exam;

public class Exam_DoWhile {
	//do while �� ����Ͽ� 10���� 0���� ī��Ʈ�ٿ�
	
	public static void main(String[] args) throws InterruptedException { //Thread ���µ� �ʿ��� exception ����
		int i = 10;
		do {
			System.out.println("���� ī��Ʈ�ٿ� "+i);
			//1�ʾ� ��� ���α׷��� ���ߴ� ����� �Ѵ�.
			Thread.sleep(1000); //Thread ��  java.lang ��Ű���� �����Ѵ�.
			i--;
		} while (i>=0);  
		System.out.println("************************");
		System.out.println("Happy new Year!");
		
	}
}
