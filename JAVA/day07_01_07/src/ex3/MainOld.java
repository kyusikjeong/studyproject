package ex3;

public class MainOld {
	public static void main(String[] args) {
		//A���� �ڿ��� ���
//		MyInter ref = new MyTeamOldA();
//	
//		MyInter ref2 = new MyTeamOldB2();
//		
		
		
		//�ΰ��� ���� �޸� �ּҸ� ������ �ִ�.
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
