package report;

public class StringToLowerUpperCaseExample {
	public static void main(String[] args) {
		//toLowerCase()�޼ҵ�� ���ڿ��� ��� �ҹ��ڷ� �ٲ� ���ο� ���ڿ��� ������ �� �����Ѵ�.
		//�ݴ�� toUpperCase()�޼ҵ�� ���ڿ��� ��� �빮�ڷ� �ٲ��ص� �����Ѵ�.
		//�� ���� ���� �޸𸮿����� ���� �����ϴ°� �ƴϰ� �ٸ� �޸� ������ ����� ���� ���� ����ȴ�.
		

		String str1 = "Java Programming";
		String str2 = "JAVA Programming";
		//String upperStr1 = str1.toUpperCase(); //�빮�ڷ� �����.
		System.out.println(str1.equals(str2));  //��ҹ��ڰ� �ٸ��Ƿ� false
		
		String lowerStr1 = str1.toLowerCase();
		String lowerStr2 = str2.toLowerCase();
	
	

		System.out.println(lowerStr1.equals(lowerStr2)); //�� �� �ҹ��ڷ� �ٲ� true 
		
		
		//equalsIgnoreCase() �޼ҵ带 ����ϸ� ��ҹ��ڷ� �����ϴ� �۾��� �����ϰ� �� ���ڿ��� ���Ѵ�.
		System.out.println(str1.equalsIgnoreCase(str2)); //true
		
		
	}
}
