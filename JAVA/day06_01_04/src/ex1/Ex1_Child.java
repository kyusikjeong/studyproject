package ex1;

public class Ex1_Child extends Ex1_Parent{
	
	//2.Object �� �޼��带 ������ �Ѱ�
	
	@Override
	public String toString() {
		return String.valueOf("��ӹ��� �ݾ�"+getPay());
		
	}
	//1.������ �ؾ߸� Ex1_Parent�� ��� ���� �� �ִ�.
	@Override
	public void moveMountain() {
		System.out.println("���� ���������� �ű� �� "+toString()+" �޾Ҵ�.");
	}
	

}
