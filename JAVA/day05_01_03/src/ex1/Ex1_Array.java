package ex1;

public class Ex1_Array {
//	int[] num1 = > 배열을 선언
//	int[] num1 = new int[3]://생성시 배열의 크기가 필요
//	배열을 선언과 생성과 초기화를 동시에
	
	private int[] num1 = {1,2,3,4,5,6,7,8};
	public Ex1_Array() {
		//배열의 인덱스는 0 부터 시작이 됨
		System.out.println("배열의 인덱스로 접근"+ num1[0]);
		System.out.println("배열의 길이"+num1.length);
		System.out.println("---------------------");
		
		
		
		for(int i=0; i<num1.length;i++) { //동적배열로 선언시 메모리 낭비를 초래할 수 있기 때문에 jdk 5 부터는 아래의 향상된 for 문을 사용하는게 좋다.
	
			System.out.println(num1[i]+"▤");
		}
		
		//향상된 for 문
		for(int e:num1) {
			System.out.println(e+"★");
		}
	}
	
	public static void main(String[] args) {
		Ex1_Array arr = new Ex1_Array();
		
		String [] str;
		str = new String[5];
		
		str[0] = "kosta188";
		str[1] = new String("kosta188");
		str[2] = new String("kosta188");
		str[3] = "kosta188";
		str[4] = "test";
		
		System.out.println("1   :"+(str[0]==str[1]));
		System.out.println("2   :"+(str[1]==str[2]));
		System.out.println("3   :"+(str[0]==str[3]));
		System.out.println("4   :"+(str[0]==str[4]));
		

		
		
		
		
	}
}
