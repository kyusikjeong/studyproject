package ex1;

public class Ex3_Array {
	private int[] num1 = {100,200};
	private int[] num2 = {1000,2000,3000};
	private int[][] test;
	
	public Ex3_Array() {
		//������ �迭���� 1���� �迭�� ���� ���������� ������ �� �ִ�.
		test = new int[2][];
		test[0] = num1;
		test[1] = num2;
	}
	
	public String getData() {
		StringBuffer mysb = new StringBuffer();
		for(int out[]: test) { //���� for���� �迭 ��ü�� �����͸� �̾ƿ��µ� ���δ�. test �� 1���� �迭�� 2ĭ�̹Ƿ� 
							 //�� �ι��� ����. 1�� ���� �ȿ� ����ִ� num�� �迭 ����ŭ ���°�.
			System.out.println("in :");
			
			//�ּҸ� ���ؼ� 1���� �迭�� �����ؼ� �о��
			for(int in : out) {
				System.out.println("out");
				mysb.append(in).append("\n");
			}
		}
		return mysb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Ex3_Array().getData());
	}
}
