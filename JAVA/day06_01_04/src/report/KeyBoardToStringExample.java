package report;

import java.io.IOException;

public class KeyBoardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100]; //���� ����Ʈ�� �����ϱ� ���� �迭 ����
		
		System.out.println("�Է�: ");
		int readByteNo = System.in.read(bytes); // �迭�� ���� ����Ʈ�� �����ϰ� ���� ����Ʈ���� ����
		
	
		String str = new String(bytes,0,readByteNo-2);   //�迭�� ���ڿ��� ��ȯ
		//0 ���� �κк��� ����° �������� �ش��ϴ� �κб��� String ��ü�� ����� ���.
		// -2�� ���� ������ ĳ��������(\r)+ �����ǵ�(\n) �κ��� ���ڿ��� ���� �ʿ䰡 ���� �����̴�.(�� �ΰ��� �Է��� ���� ���� �پ�����)
		//	for(byte b : bytes) {
		//		System.out.println(b);
		//	} ���� ĳ��������,�����ǵ尡 ��� �پ��ִ��� Ȯ�� �����ϴ�.
		//
		System.out.println(str);
	}
}
