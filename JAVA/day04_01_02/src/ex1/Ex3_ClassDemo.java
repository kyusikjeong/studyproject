package ex1;

public class Ex3_ClassDemo {
	private int pay;
	//클래스안에 속성을 정의할 수있다.
	//접근제한자 private 사용
	///A 팀이든 B팀이든 pay란 자원에 직접 접근하지 못하도록 한다.
	
	//this : 현재 클래스의 주소를 참조(자신의 주소값)
	public void insertPay(int pay,String pwd) {
		//this.멤버필드의 pay = 지역변수 pay
		if (pwd.equals("1")){
			this.pay = pay;
		} else {
			System.out.println("경고메세지!");
		}
		
	}
	//멤버필드의 pay값을 반환해주는 함수
	public int viewPay() {
		
		return pay;
	}
}
