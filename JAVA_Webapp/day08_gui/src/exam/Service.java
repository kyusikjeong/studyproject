package exam;

import java.util.Scanner;

public class Service {
	
	public String service(String name, String menu) { //main���� �Է¹��� ������ �޼ҵ� ����.
            StringBuffer sb = new StringBuffer();
                if(menu.equals("1")) {
			sb.append(new KoreaFood().food(name)); //���޹��� �޴���ȣ�� ������ �з��ϰ� �ֹ��� �̸��� �����Ѵ�.
		}else if(menu.equals("2")){
			sb.append(new IndoFood().food(name));
		}else if(menu.equals("3")){
                        sb.append(new ChiFood().food(name));
                }
            return sb.toString();   //���������� �ֹ� ������ ����ϱ� ���� stringbuffer �� ���� �� �����Ѵ�.
	}
}
