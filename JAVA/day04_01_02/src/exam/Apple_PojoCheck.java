package exam;

public class Apple_PojoCheck {
	//��ȿ���˻�. ����Ͻ� ����. �������� ����� ���.
	private Apple_Pojo ap;
	
	public void setCheck(Apple_Pojo ap) {
		if (ap.getType().equals("���")) {
			this.ap = ap;
		} else {
			System.out.println("����� �˻� �� �� �ֽ��ϴ�.");
		}
	}
	
	public void printCheck() {
		if(ap != null) {
			
			int size = ap.getSize();
			String apSize = "";
			if(10<= size && size <20) {
				apSize = "��";
			} else if(20<=size && size <30) {
				apSize = "��";
			} else if(30<=size) {
				apSize = "Ư";
			}
			
			int status = ap.getStatus();
			String aStatus = "";
			
			if(status ==1) {
				aStatus = "����";
			} else if(status ==2) {
				aStatus = "���� ����";
			} else if(status ==3) {
				aStatus = "�ǸźҰ�";
			}
			
			
			System.out.println("����� �������� "+ap.getOrigine() +" �Դϴ�.");
			System.out.println("����� ���´� "+aStatus+" �Դϴ�.");
			System.out.println("����� ũ��� "+apSize+" �Դϴ�.");
			
		}
	}

}
