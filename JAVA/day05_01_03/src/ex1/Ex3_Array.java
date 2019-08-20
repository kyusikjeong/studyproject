package ex1;

public class Ex3_Array {
	private int[] num1 = {100,200};
	private int[] num2 = {1000,2000,3000};
	private int[][] test;
	
	public Ex3_Array() {
		//다차원 배열에서 1차원 배열의 수를 가변적으로 설정할 수 있다.
		test = new int[2][];
		test[0] = num1;
		test[1] = num2;
	}
	
	public String getData() {
		StringBuffer mysb = new StringBuffer();
		for(int out[]: test) { //향상된 for문은 배열 객체의 데이터를 뽑아오는데 쓰인다. test 의 1차원 배열이 2칸이므로 
							 //총 두번만 돈다. 1번 돌고 안에 들어있는 num의 배열 수만큼 도는것.
			System.out.println("in :");
			
			//주소를 통해서 1차원 배열에 접근해서 읽어옴
			for(int in : out) {
				System.out.println("out");
				mysb.append(in).append("\n");
			}
		}
		return mysb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new Ex3_Array().getData());
	}
}
