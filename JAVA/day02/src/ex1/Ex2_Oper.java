package ex1;

public class Ex2_Oper {
	public static void main(String[] args) {
		//����������: && ������, || ������, ! ����
		//true && true -> true / false && true �϶� true �� ������� �ʴ´�.
		//|| �� false || true �� �Ǵ��� true ���� �����Ѵ�.
		int a = 10;
		int b = 20;
		boolean c = ((a +=12)> b) || (a == (b+=2)); //���� ������ true �̹Ƿ� ���� ������ ������� �ʴ´�.
		System.out.println("c= "+c);
		System.out.println("a= "+a);
		System.out.println("b= "+b); 
		System.out.println("--------------------");
		
	}
}