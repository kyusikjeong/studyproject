package ex1;

public class Ex2_Main {
	public static void main(String[] args) {
		Ex2_ClassDemo ref = new Ex2_ClassDemo();
		
		System.out.println("������ pay :"+ +ref.pay +", team : "+ref.team);
		ref.setTeam("newYear");
		System.out.println("����� team : "+ref.team );
		
		ref.setValue(20, "Happy new year!");
		System.out.println("����� pay�� : "+ref.pay+", team �� :"+ref.team);
		
	}
}
