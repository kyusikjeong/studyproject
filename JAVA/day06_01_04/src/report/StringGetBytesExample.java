package report;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		//byte[] bytes = "���ڿ�".getBytes();
		//byte[] bytes = "���ڿ�".getBytes(Charset charset);
		//���ڿ��� ����Ʈ �迭�� ��ȯ�ϴ� �޼ҵ��. ��ǥ���� ����, ��Ʈ��ũ�� ���ڿ��� �����ϰų�
		//���ڿ��� ��ȣȭ�� �� ���ڿ��� ����Ʈ �迭�� ��ȯ�Ѵ�.
		//Ư���� ���ڼ����� ���ڵ��� ����Ʈ �迭�� �������� �ι�° ���ø� ����ؼ� �Ʒ��� ���� ����ϸ� �ȴ�.
//		try {
//			byte[] bytes = "���ڿ�".getByte("EUC-KR");
//			byte[] bytes = "���ڿ�".getByte("UTF-8");
//		} catch(UnsupportedEncodingException e) {
//		} 
		//�ش� �������� ����ϸ� �Է��� ���ڼ����� ���ڵ��� �迭�� ���Ϲ��� �� �ִ�. 
		//EUC-KR�� ���ĺ� 1����Ʈ, �ѱ��� 2����Ʈ�� ��ȯ�ϰ�, UTF-8�� ���ĺ��� 1����Ʈ, �ѱ��� 3����Ʈ�� ��ȯ�Ѵ�. 
		//getBytes(Charset charset) �޼ҵ�� �߸��� ���ڼ��� �Ű������� �� ���(ex - getByte("aaa");)
		//UnsupportedEncodingException ���ܰ� �߻��ϹǷ� ���� ó���� �ʿ��ϴ�.
		
		//�ܼ��ϰ� String(byte[] bytes)�����ڸ� �̿��ؼ� ���ڵ��ϸ� �ý����� �⺻ ���ڼ��� �̿��ϹǷ� �ý��� �⺻ ���ڼ°�
		//�ٸ� ���ڼ����� ���ڵ��� ����Ʈ �迭�ϰ�� ���� �����ڸ� �̿��� ���ڵ��ؾ��Ѵ�.
		//String str = new String(byte[] bytes, String charsetName);
		String str = "�ȳ��ϼ���";
		
		byte[] bytes1 = str.getBytes(); //�⺻ ���ڼ����� ���ڵ�
		System.out.println("bytes1.length: "+bytes1.length);
		String str1 = new String(bytes1); //�⺻ ���ڼ����� ���ڵ�
		System.out.println("bytes1->String: "+str1); 
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR"); //EUC-KR ���� ���ڵ�
			System.out.println("bytes2.length: "+bytes2.length);
			String str2 = new String (bytes2,"EUC-KR");//EUC-KR ���� ���ڵ�
			System.out.println("bytes2 -> String "+str2);
			
			byte[] bytes3 = str.getBytes("UTF-8");//UTF-8 ���� ���ڵ�
			System.out.println("bytes3.length: "+bytes3.length);
			String str3 = new String (bytes2,"UTF-8");//UTF-8 ���� ���ڵ�
			System.out.println("bytes3 -> String "+str3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
}
