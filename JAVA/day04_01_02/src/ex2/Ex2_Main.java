package ex2;

import ex1.Ex1_Main;


public class Ex2_Main {
	public static void main(String[] args) {
		Ex2_MethodDemo ref = new Ex2_MethodDemo(); //�츮�� //heap �� ��ü����
		
		Ex2_ColorOffice eo1 = new Ex2_ColorOffice();//A
		Ex2_ColorOffice eo2 = new Ex2_ColorOffice();//B
		
		
		
		
		//�޼��� ���ڰ����� �츮���� �ּҸ� ���� �����Ѵٸ�..
		
		//���� �ּҸ� ���� �ִٴ� ����
		//�޼��� ȣ��� ref �� Ȩ�� �ּҰ��� �����ϰ� �ִ�.
		
		eo1.jobPaint(ref, "�����"); //100���� �ּҰ�
		eo2.jobPaint(ref, "����");
		
		//�޸� ������ �׸��鼭 �� red �� �������� �ѹ� �����غ���
		
		System.out.println("���� Ȯ�� : "+ref.viewColor());
		
	}
}
