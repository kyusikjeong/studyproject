package exam;

public class Exam2 {
	public static void main(String[] args) {
		int i = 1;
		int sum =0;
		do {
			sum += i;
			i++;
		} while(i<=100);
		
		System.out.println("1 부터 100까지의 합 "+sum);
	}
}
