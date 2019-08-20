package ex1;

public class Ex2_Main {
	public static void main(String[] args) {
		Ex2_ClassDemo ref = new Ex2_ClassDemo();
		
		System.out.println("변경전 pay :"+ +ref.pay +", team : "+ref.team);
		ref.setTeam("newYear");
		System.out.println("변경된 team : "+ref.team );
		
		ref.setValue(20, "Happy new year!");
		System.out.println("변경된 pay값 : "+ref.pay+", team 값 :"+ref.team);
		
	}
}
