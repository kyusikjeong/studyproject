package ex1;

public class Ex3_Demotion {
	//4byte ������ ������ JVM ����� �ڵ����� 4byte �� �°��ؼ� ������
	//demotion, promotion
	//java Ex3_Demotion => JVM�� ���� �� main �޼��带 ����
	public static void main(String[] args) {
		//���� ����
		byte num1 = 10;
		byte num2 = 20;
		//System.out.println("num1 : "+num1+ "\nnum2 : "+num2);
		//byte num3 = num1+num2;  //4byte ������ �����̹Ƿ� �°ݵǼ� �ٿ�ĳ���� �϶�� ������ �߻�. demotion �߻�. 
		byte num3 = (byte) (num1+num2);
		System.out.println("num3 = "+num3);
		
		//����)short sh1, sh2�� ���� ���� 100,200�� ����
		//short sh3�� ���� ������ �Ŀ� ����� �غ��ô�.
		short sh1 = 100;
		short sh2 = 200;
		short sh3 = (short)(sh1+sh2);
		System.out.println("sh3 : "+sh3);
		
		char c1 = 'A';//65
		short c2 = 1;
		//char c3 = c1+c2 // ������Ÿ���� ��ġ���� ������ ĳ������ ���־�� ������ �����ϹǷ� �����߻�. 
		char c3 = (char) (c1+c2);
		System.out.println(c3);
		//���� ������ 4byte ������ �����̹Ƿ� demotion �߻�.
		
	}
}
