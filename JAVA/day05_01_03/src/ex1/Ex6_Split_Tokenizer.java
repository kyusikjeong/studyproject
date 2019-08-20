package ex1;

import java.util.StringTokenizer;

public class Ex6_Split_Tokenizer {
	public static void main(String[] args) { 
		//StringTokenizer는 의미없는 whitespace 를 토큰으로 취급하지 않는다.
		//split 는 whitespace도 의미있는 토큰으로 취급
		String str = "김길동■구하라☆김수현■전지현■■수지";
		StringTokenizer stz = new StringTokenizer(str,"■"); //StringTokenizer는 많이 쓰이는 클래스이므로 반드시 기억할 것.
		System.out.println("Total Token: "+stz.countTokens());
		
		
//		System.out.println("0: "+stz.nextToken());
//		System.out.println("1: "+stz.nextToken());
//		System.out.println("2: "+stz.nextToken());
//		System.out.println("3: "+stz.nextToken());
		
		while(stz.hasMoreTokens()) { //토큰을 인식하면 True
			System.out.println(stz.nextToken()); //토큰을 잘라야지 값을 반환
		}
		
		System.out.println("-------------------");
		String[] arr = str.split("■");
		System.out.println("배열의 길이 "+arr.length);
		for(String e: arr) {
			System.out.println(e);
		}
	}
}
