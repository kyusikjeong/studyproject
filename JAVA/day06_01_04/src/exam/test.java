package exam;

public class test {
	public static void main(String[] args) {
		int [][] array = {
				{1,1},
				{1,1,1},
				{1,1,1,100}
		};
		int sum=0;
		int count = 0;
		for(int[] out : array) {
			for(int in : out) {
				sum += in;
				count++;
				
			}
		}
		System.out.println(sum);
		double avg;
		avg = sum/count;
		int test = array.length;
		System.out.println(count);
		System.out.println(avg);
	}
}	
