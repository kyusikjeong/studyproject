package report;

public class StringSubstringExample {
	public static void main(String[] args) {
		//substring()�޼ҵ�� �־��� �ε������� ���ڿ��� �����Ѵ�.
		//substring(int beginIndex,int endIndex)�� �־��� ���۰� �� �ε��� ������ ���ڿ��� �����Ѵ�.
		//substring(int beginIndex)�� �־��� �ε������� ������ ���ڿ��� �����Ѵ�.
		
		String ssn = "880815-1234567";
		
		String firstNum = ssn.substring(0,6); 
		System.out.println(firstNum); //������ 0�̰� 6��°�� - ������ ���ڿ��� �����ϹǷ� 880815���
		
		String secondNum = ssn.substring(7);
		System.out.println(secondNum); //7���� ������ �̹Ƿ� 1234567 ���
	}
}
