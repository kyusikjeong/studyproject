package report;

public class StringTrimExample {
	//trim()�޼ҵ�� ���ڿ��� �յ� ������ ������ ���ο� ���ڿ��� �����ϰ� �����Ѵ�.
	//trim()�޼ҵ�� �յ��� ���鸸 ������ �� �߰��� ������ �������� �ʴ´�.
	//trim()�޼ҵ� ���� ������ �޸� �ּҿ� �ִ� ���� ������ �����ϴ°� �ƴϰ� ���ο� �ּҰ��� ������ ������ ���� �����Ѵ�.
	
	public static void main(String[] args) {
		String tel1 = " 02";
		String tel2 = "123  ";
		String tel3 = "   12 34   ";  //�߰��� ������ ���ŵ��� �ʴ°� Ȯ�ΰ���
		
		String tel = tel1.trim() + tel2.trim() + tel3.trim();
		System.out.println(tel);  //0212312 34 ���
		
	}
}
