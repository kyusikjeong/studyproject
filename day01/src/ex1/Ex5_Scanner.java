package ex1;
//�ܺ��� Ŭ������ �ҷ��� �� ���
import java.util.Scanner;

public class Ex5_Scanner {
	public static void main(String[] args) {
		//Ű����κ��� �Է°��� �Է¹ޱ� ���� Ŭ����
		//�����ؼ� �ѹ� ��� �غ��ô�. �����ϱ�.
		//���� �ڷ��� ������ = new ������ Ŭ������();
		//System.out �� ���
		//System.in �� �Է� 
		//������������ ������ ��ü�� �ּҰ��� ���� 100����..
		Scanner sc = new Scanner(System.in);
		System.out.print("�Է� :");
		//sc ���� ������ ����ؼ� nextLine()�� ȣ���ؼ� �Էµ� ����
		//���ڿ��� ��ȯ�Ѵ�.
		String msg = sc.nextLine(); // ���(���ٴ����� �Է� �� enter)
		System.out.println("res :" + msg);
		System.out.println("�̸� :");
		
		
		String name = sc.nextLine(); //�����Ǿ��ִ� �ڵ带 ����...
		System.out.println("name: "+name);
		
		
	}
}
