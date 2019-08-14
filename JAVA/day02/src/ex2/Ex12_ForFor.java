package ex2;

public class Ex12_ForFor {
	public static void main(String[] args) {
		//Å« for¹®ÀÇ i
		for(int i = 1;i<=9;i++) {
			for(int j = 2; j<= 9; j++) {
				System.out.print(j+"*"+i+"="+j*i+"  ");
			}
			System.out.println("");
		}
	}
}
