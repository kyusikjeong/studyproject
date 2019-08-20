package report;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strVar1 = new String("�Ź�ö");
		String strVar2 = "�Ź�ö";
		String strVar3 = "�Ź�ö";
		//�ڹٴ� ���ڿ� ���ͷ��� �����ϴٸ� ������ String ��ü�� �����ϵ��� �Ǿ��ִ�.(������ ��ü����)
		//�׷��Ƿ� strVar2�� strVar3�� ������ String��ü�� �����Ѵ�.
		//��ü���� ���ڿ��� ���ϰ� �ʹٸ� equals()�޼ҵ带 ����ϸ� �ȴ�.
		System.out.println((strVar1 == strVar2));  //false
		System.out.println((strVar2 == strVar3));  //true
		
		System.out.println(strVar1.equals(strVar2)); //true
		System.out.println(strVar2.equals(strVar3)); //true
		
		if(strVar1 == strVar2) {
			System.out.println("���� String ��ü�� ����");
		} else {
			System.out.println("�ٸ� String ��ü�� ����"); //1�� new�� ��ü�� ���� ���������Ƿ� ������ ���
		}
		
		if(strVar1.equals(strVar2)){
			System.out.println("���� ���ڿ��� ����"); //���ڿ� ���ͷ��� �񱳽� �����Ƿ� ������ ���
		} else {
			System.out.println("�ٸ� ���ڿ��� ����");
		}
	}
}
