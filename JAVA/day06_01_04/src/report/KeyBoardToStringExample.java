package report;

import java.io.IOException;

public class KeyBoardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100]; //읽은 바이트를 저장하기 위한 배열 생성
		
		System.out.println("입력: ");
		int readByteNo = System.in.read(bytes); // 배열에 읽은 바이트를 저장하고 읽은 바이트수를 리턴
		
	
		String str = new String(bytes,0,readByteNo-2);   //배열을 문자열로 변환
		//0 번재 부분부터 세번째 변수값에 해당하는 부분까지 String 객체로 만들어 출력.
		// -2를 해준 이유는 캐리지리턴(\r)+ 라인피드(\n) 부분은 문자열로 만들 필요가 없기 때문이다.(이 두개는 입력한 값의 끝에 붙어있음)
		//	for(byte b : bytes) {
		//		System.out.println(b);
		//	} 찍어보면 캐리지리턴,라인피드가 어디에 붙어있는지 확인 가능하다.
		//
		System.out.println(str);
	}
}
