package ex1;
/* Ex1_parent : 추상메서드를 가진 클래스는 반드시 추상 클래스이다. */
public  class Ex1_Parent {
	//상속 받을 자원
	private final int pay = 1000000;
	//추상 메서드:미션!
	//abstract public void moveMountain();
	public void moveMountain(){}
	public int getPay() {
		return pay;
	}
}
