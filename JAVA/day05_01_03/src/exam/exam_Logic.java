package exam;

;

public class exam_Logic {
	
	private exam_BoardMember bm;
	public void setMember(exam_BoardMember bm) { //boolean setMember(~) �ְ� ��ȿ�� üũ���� return false �ִ¹���� ����.
		//������ ���̰��� �Ǻ��ؼ� �������� �̼������� �����ϰ� �̼����̸� �����͸� �Է����� ���ϵ��� ����
		this.bm = bm;
		System.out.println("test");
	}
	public void printMember() {
		String[][] str = bm.getTest();
		int i=0;
	
		Loop:for(String[]out: str) {
				for(String in : out) {
					System.out.println("�ۼ���: "+str[i][0]);
					System.out.println("������: "+str[i][1]);
					System.out.println("�۳���: "+str[i][2]);
					System.out.println("---------------");
					
					if( i<4) {
						i++;
					} else {
						break Loop;
					}
				}
			
		}
	}
}
