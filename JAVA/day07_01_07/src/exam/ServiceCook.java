package exam;
//���� ���͵�: �������̽� ���� �н�����
//��� ����Ŭ���� ����

import java.util.Scanner;

public class ServiceCook {
	//���񽺰� �������̽��� ����ϴ� ���
	//�տ� ���� ����
	//1.����� UML
	//2.�ҽ�
	//����Ͻ� ����
	
	//MyInter in;

	public void service(String name, String menu) { //main���� �Է¹��� ������ �޼ҵ� ����.
		if(menu.equals("1")) {
//			in = new KoreaCook();  //�̷� �����ε� ��ü���� �� ������ �ȴ�..
//			in.orderCook(name);
			new KoreaCook().orderCook(name);  //�޴��� 1�̸� KoreaCook ��ü ������ ������ orderCook�޼��带 ȣ��
		}else if(menu.equals("2")){
			new IndoCook().orderCook(name);  //�޴���2�̸� orderCook ��ü ������ ������ orderCook�޼��带 ȣ��
		}
	}
	
}
