package exam;

public class Exam4_Aircon {
	
	//
	boolean power;
	boolean temButton;
	
	int temp=16;
	int option=0;
	
	
	public void setPower(boolean p) {
		power = p;
		if (p == true) {
			System.out.println("������ �������ϴ�.");
		} else {
			System.out.println("������ �������ϴ�.");
			System.exit(0);
		}
		
	}
	public  void setTemp(boolean t) {
		if(t == true) {
			if(temp < 31 ) {
				temp++;
			}
			System.out.println("����� �µ��� "+temp+" �� �Դϴ�.");
		} else if (t== false){
			if(temp > 16) {
				temp--;
			}
			System.out.println("���ҵ� ���� �µ��� "+temp+" �� �Դϴ�.");
		}
	}
	public  void setOption(int o) {
		switch(o) {
		case 1: 
			System.out.println("��ǳ���� �����Ͽ����ϴ�");
			break;
		case 2:
			System.out.println("��ǳ���� �����Ͽ����ϴ�");
			break;
		case 3:
			System.out.println("��ǳ���� �����Ͽ����ϴ�");
			break;
		default:
			System.out.println("�߸��� ��ȣ�Դϴ�.");
			break;
			
		}
	}
	
	
}
