package ex1;

public class Ex02_JavaContinue {
	public static void main(String[] args) {
		ex:
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if (j==3) {
					continue ex; //3일때 문장 수행하지 않고 넘어감
				}
				System.out.println("i :"+i+" , j : "+j); 
			}
		}
	}
}
