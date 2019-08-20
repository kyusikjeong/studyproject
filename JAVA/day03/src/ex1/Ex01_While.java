package ex1;

public class Ex01_While {
	public static void main(String[] args) {
		
		int i = 1;
		String msg = "";
		
		
		while(i <=10) {
			if(i% 2==0) {
				msg = "Â¦¼ö";
				
			} else {
				msg ="È¦¼ö";
			}
			
			System.out.println(i+"´Â "+msg+" ÀÔ´Ï´Ù.");
			i++;
		}
	}
}
