package ex1;

import java.util.Scanner;

public class Ex5_MathRandom {
	public static void main(String[] args) {
		int comNum = (int)(Math.random()*10)+1;
	
		System.out.println("1부터 10까지의 숫자중에서 하나를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		
		int uNum = Integer.parseInt(sc.nextLine());
		System.out.println("cpu의 값 : "+comNum+" / "+"입력한 값 : "+uNum+" / 일치여부 :"+(comNum == uNum ? "맞았습니다" : "틀렸습니다"));
		//도구 : Scanner, Integer.parseInt(),sout ... random
		//사용자 UI : 
		//1 ~ 10 까지의 숫자중에 하나 입력
		
		/* String msg ="";
		 * if(uNum == comNum) {
		 * 		msg = "맞았습니다";
		 * } else {
		 * 		msg = "틀렸습니다";
		 * }
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
	}
}
