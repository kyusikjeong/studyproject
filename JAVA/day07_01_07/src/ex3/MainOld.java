package ex3;

public class MainOld {
	public static void main(String[] args) {
		//A팀의 자원을 사용
//		MyInter ref = new MyTeamOldA();
//	
//		MyInter ref2 = new MyTeamOldB2();
//		
		
		
		//두개는 같은 메모리 주소를 가지고 있다.
//		MyColor ref = new MyTeamOldA();
//		MyDraw ref1 = (MyDraw)ref;

//		ref.draw();
//		ref.paint();
//		ref2.draw();
//		ref2.paint();
		MyInter[] ref = new MyInter[2];
		
		ref[0] = new MyTeamOldA();
		ref[1] = new MyTeamOldB2();
		
		for (MyInter e : ref) {
			e.draw();
			e.paint();
		}
	
	}
}
