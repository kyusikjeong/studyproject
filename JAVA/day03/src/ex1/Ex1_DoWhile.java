package ex1;

public class Ex1_DoWhile {
	public static void main(String[] args) {
		int i = 0; //�ʱ�ȭ
		do { //do while ���� Ư¡�� ��� ���๮�� ������ �ѹ��� ����ȴٴ� ���̴�.
			if(i%2 ==0) {
				System.out.println("¦  :"+i);
			} else {
				System.out.println("Ȧ : "+i);
			}
			i++; //������
		} while( i<= 10); //���ǽ�. �ش� ������ true �� ��� �ݺ�.
		
		System.out.println("-------------");
	}
}
