package ex1;

public class Ex01_While {
	public static void main(String[] args) {
		
		int i = 1;
		String msg = "";
		
		
		while(i <=10) {
			if(i% 2==0) {
				msg = "¦��";
				
			} else {
				msg ="Ȧ��";
			}
			
			System.out.println(i+"�� "+msg+" �Դϴ�.");
			i++;
		}
	}
}
