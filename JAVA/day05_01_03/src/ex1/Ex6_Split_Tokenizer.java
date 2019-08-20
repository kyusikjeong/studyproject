package ex1;

import java.util.StringTokenizer;

public class Ex6_Split_Tokenizer {
	public static void main(String[] args) { 
		//StringTokenizer�� �ǹ̾��� whitespace �� ��ū���� ������� �ʴ´�.
		//split �� whitespace�� �ǹ��ִ� ��ū���� ���
		String str = "��浿�ᱸ�϶�ٱ������������������";
		StringTokenizer stz = new StringTokenizer(str,"��"); //StringTokenizer�� ���� ���̴� Ŭ�����̹Ƿ� �ݵ�� ����� ��.
		System.out.println("Total Token: "+stz.countTokens());
		
		
//		System.out.println("0: "+stz.nextToken());
//		System.out.println("1: "+stz.nextToken());
//		System.out.println("2: "+stz.nextToken());
//		System.out.println("3: "+stz.nextToken());
		
		while(stz.hasMoreTokens()) { //��ū�� �ν��ϸ� True
			System.out.println(stz.nextToken()); //��ū�� �߶���� ���� ��ȯ
		}
		
		System.out.println("-------------------");
		String[] arr = str.split("��");
		System.out.println("�迭�� ���� "+arr.length);
		for(String e: arr) {
			System.out.println(e);
		}
	}
}
