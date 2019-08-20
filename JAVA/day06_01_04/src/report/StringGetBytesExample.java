package report;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
	public static void main(String[] args) {
		//byte[] bytes = "문자열".getBytes();
		//byte[] bytes = "문자열".getBytes(Charset charset);
		//문자열을 바이트 배열로 변환하는 메소드들. 대표적인 예로, 네트워크로 문자열을 전송하거나
		//문자열을 암호화할 때 문자열을 바이트 배열로 변환한다.
		//특정한 문자셋으로 인코딩된 바이트 배열을 얻으려면 두번째 예시를 사용해서 아래와 같이 사용하면 된다.
//		try {
//			byte[] bytes = "문자열".getByte("EUC-KR");
//			byte[] bytes = "문자열".getByte("UTF-8");
//		} catch(UnsupportedEncodingException e) {
//		} 
		//해당 형식으로 사용하면 입력한 문자셋으로 인코딩된 배열을 리턴받을 수 있다. 
		//EUC-KR은 알파벳 1바이트, 한글은 2바이트로 변환하고, UTF-8은 알파벳은 1바이트, 한글은 3바이트로 변환한다. 
		//getBytes(Charset charset) 메소드는 잘못된 문자셋을 매개값으로 줄 경우(ex - getByte("aaa");)
		//UnsupportedEncodingException 예외가 발생하므로 예외 처리가 필요하다.
		
		//단순하게 String(byte[] bytes)생성자를 이용해서 디코딩하면 시스템의 기본 문자셋을 이용하므로 시스템 기본 문자셋과
		//다른 문자셋으로 인코딩된 바이트 배열일경우 다음 생성자를 이용해 디코딩해야한다.
		//String str = new String(byte[] bytes, String charsetName);
		String str = "안녕하세요";
		
		byte[] bytes1 = str.getBytes(); //기본 문자셋으로 인코딩
		System.out.println("bytes1.length: "+bytes1.length);
		String str1 = new String(bytes1); //기본 문자셋으로 디코딩
		System.out.println("bytes1->String: "+str1); 
		
		try {
			byte[] bytes2 = str.getBytes("EUC-KR"); //EUC-KR 으로 인코딩
			System.out.println("bytes2.length: "+bytes2.length);
			String str2 = new String (bytes2,"EUC-KR");//EUC-KR 으로 디코딩
			System.out.println("bytes2 -> String "+str2);
			
			byte[] bytes3 = str.getBytes("UTF-8");//UTF-8 으로 인코딩
			System.out.println("bytes3.length: "+bytes3.length);
			String str3 = new String (bytes2,"UTF-8");//UTF-8 으로 디코딩
			System.out.println("bytes3 -> String "+str3);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
	}
}
