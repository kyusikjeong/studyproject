package ex1;

import java.util.Scanner;

public class Ex2_Array {
	private String[][] arr1;
	private String msg = "A";
	private Scanner sc;
	private int count;
	
	
	public Ex2_Array() { //배열을 사용하는 이유. 데이터를 잠깐 저장해두기 위해.  
		sc = new Scanner(System.in);
		arr1 = new String[2][3];
		
		for(int i =0; i<arr1.length;i++) {
			for(int j=0; j<arr1[i].length; j++) {
				System.out.println("문자열 입력 ["+i+"]"+"["+j+"]");
				msg = sc.nextLine();
				arr1[i][j] = msg;
				count++;
			}
		}
	}
	
	public String getData() {
		StringBuffer mysb = new StringBuffer();
//		for(int i=0; i<arr1.length;i++) {
//			for(int j =0; j<arr1[i].length;j++) {
//				mysb.append("arr1[").append(i).append("][").append(j);
//				mysb.append("] :").append(arr1[i][j]).append("\n");
//				
//			}
//		}
		//1차원 배열의 갯수 : 2
		for(String[] out: arr1) {
			//주소를 통해서 1차원 배열에 접근함
			for(String in:out) {
				mysb.append(in).append("\n");
//				mysb.append("] :").append(arr1[i][j]).append("\n");
			}
		}
		return mysb.toString();
	}
	
	public static void main(String[] args) {
		Ex2_Array ref = new Ex2_Array();
		ref.getData();
		
		System.out.println(new Ex2_Array().getData());
	}
	
}
