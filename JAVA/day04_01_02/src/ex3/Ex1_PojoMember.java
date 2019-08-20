package ex3;

import ex2.Ex3_PojoDemo;

public class Ex1_PojoMember {
	//1.ȸ���� ������ ����ϴ� Ŭ������ ����� ����
	//��ü�� �⺻���� null -> new�����ȵ� �ּ�...
	private Ex3_PojoDemo ep; //100����
	
	//2.Ex3_PojoDemo �� ��ü�� ������ ��
	//���� Ŭ������ ����� �����ϴ� �޼��带 ����
	public void setMember(Ex3_PojoDemo ep) { //boolean setMember(~) �ְ� ��ȿ�� üũ���� return false �ִ¹���� ����.
		//������ ���̰��� �Ǻ��ؼ� �������� �̼������� �����ϰ� �̼����̸� �����͸� �Է����� ���ϵ��� ����
		if (ep.getAge()>=19) {
			this.ep = ep;
		} else {
			System.out.println("�̼����ڴ� �����Ͻ� �� �����ϴ�.");
		}
		
	}
	
	//3.ep(ȸ��)�� ���� ����ϴ� �޼���
	public void printMember() {
		if(ep != null) {
			System.out.println("ȸ���� ��ȣ: "+ep.getNum());
			System.out.println("�̸�"+ep.getName());
			System.out.println("���̵�: "+ep.getId());
			
			if (ep.isAgree() == true) {
				System.out.println("���� ���� �Ͽ����ϴ�");
				
			} else {
				System.out.println("���� �̵��� �Ͽ����ϴ�.");
			}
		}
	}
}
