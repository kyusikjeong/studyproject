package ex2;

public class Ex2_ColorOffice {
	
	private Ex2_MethodDemo em;
	
	public void jobPaint(Ex2_MethodDemo em,String color) {
		//일반 자료형으로 데이터를 보내는 것이 아니라
		//참조 자료형으로 Ex2_MethodDemo 주소값을 인자로 전달
		em.paintColor(color);
	}
}
