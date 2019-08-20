package ex1;

public class Ex2_JavaContinue {
	public static void main(String[] args) {
		
		for(int i=0;i<10; i++) {
			
			if(i == 2|| i == 5) { 
				continue;			//2나 5를 만나면 다음 반복 구간으로 넘어간다. 아래의 코드를 실행하지 않고 증감식으로 바로이동... 
			}
			System.out.println(i);
		}
	}
}
