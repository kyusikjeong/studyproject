package ex1;

public class Ex3_SwitchLabel {
	public static void main(String[] args) {
		
		Loop: for(int i =0; i<5;i++) {
			
			//jdk 5부터 지원
			for (int j=0;j<5;j++) {
				if (j==3) {
					break Loop;
					
				}
				System.out.println(j+","+i);
				
			}
		}
	}
}
