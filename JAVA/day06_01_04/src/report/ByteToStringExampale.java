package report;

public class ByteToStringExampale {
	public static void main(String[] args) {
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes); 
		//�Է��� bytes �迭�� ���ڿ��� ��ȯ�Ѵ�.
		//��,�迭 ���ο� �Է��� ���� ��ġ�ϴ� �ڵ忡 �ش��ϴ� ���ڿ��� ��µǰ� �ȴ�. (Editplus���� Ȯ���ߴ� ����)
		System.out.println(str1);
		//Hello Java ���
		
		String str2 = new String(bytes, 6,4);
		//bytes �迭�ȿ� 7��°�� �ش��ϴ�(0���� �����ϹǷ�) 74 ���� 97������ �ش��ϴ� ���ڿ��� ��µȴ�. 
		System.out.println(str2);
		//JAVA ���
	}
}
