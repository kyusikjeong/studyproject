package report;

public class StringReplaceExample {
	public static void main(String[] args) {
		//replace()�޼ҵ�� ù ��° �Ű����� ���ڿ��� ã�� �ι�° �Ű����� ���ڿ��� ��ġ�� ���ο� ���ڿ��� �����ϰ� �����Ѵ�.
		//�޸� �����ȿ� ���� �����ؼ� �װ��� �����ϴ°� �ƴ϶� ���ο� �޸𸮰����� ��ü�� ���ڿ��� ����ȴ�.
		
		
		String oldStr = "�ڹٴ� ��ü������ �Դϴ�. �ڹٴ� ǳ���� API�� �����մϴ�.";
		String newStr = oldStr.replace("�ڹ�", "JAVA"); 
		System.out.println(oldStr);
		System.out.println(newStr); //�ڹٰ� JAVA�� ����Ǿ� ���
		
	
	}
}
