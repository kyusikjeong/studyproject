package ex1;

public class Ex2_JavaContinue {
	public static void main(String[] args) {
		
		for(int i=0;i<10; i++) {
			
			if(i == 2|| i == 5) { 
				continue;			//2�� 5�� ������ ���� �ݺ� �������� �Ѿ��. �Ʒ��� �ڵ带 �������� �ʰ� ���������� �ٷ��̵�... 
			}
			System.out.println(i);
		}
	}
}
