package ex1;

public class Ex1_Main {
	public static void main(String[] args) {
		//�߻� Ŭ������ �ش� �θ� Ŭ������ �ٸ� Ŭ�������� �������� �ʵ��� �Ҷ��� �����ؼ� ����Ѵ�.
		Ex1_Parent ref = new Ex1_Parent();
		ref.moveMountain();
		//�͸� ���� Ŭ������ ���� ��!
		
		new Ex1_Parent() {
			@Override
			public void moveMountain() {
				System.out.println("���ο� ������!");
			}
		}.moveMountain();
	}
}
