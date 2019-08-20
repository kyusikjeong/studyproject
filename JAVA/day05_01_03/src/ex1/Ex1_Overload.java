package ex1;

public class Ex1_Overload {
		public void drawCircle(int r) {
			System.out.println("지름이 "+r+"인 원을 그린다");
			
		}
		public void drawRec(int w, int h) {
			System.out.println("너비 "+w+", 높이: "+h+"인 사각형을 그린다. ");
			
		}
		public void lineDraw(int x, int y, int len) {
			System.out.println("좌표 x: "+x+"좌표 y:"+y);
			System.out.println("길이가 "+len+"인 선을 그린다.");
			
			
		}
		
		public static void main(String[] args) {
			Ex1_Overload ref = new Ex1_Overload();
			ref.lineDraw(10, 20, 30);
			
			ref.draw(20);
			ref.draw(20, "높~은");
			ref.draw(10, 20, 300);
			//ref.d
		}
		
		
		//메소드 오버로딩: 메소드의 이름을 같게 해둠으로써
		//메소드의 가독성과 일관성을 보장한다.
		
		public void draw(int r) {
			System.out.println("지름이 "+r+"인 원을 그린다");
		}
		public void draw(int w,String h) {
			System.out.println("너비 "+w+", 높이: "+h+"인 사각형을 그린다. ");
		}
		public void draw(String a,int b) {
			System.out.println("너비 "+a+", 높이: "+b+"인 사각형을 그린다. ");
		
		}
		public void draw(int x, int y, int len) {
			System.out.println("좌표 x: "+x+"좌표 y:"+y);
			System.out.println("길이가 "+len+"인 선을 그린다.");
		}
		
		
		
	}

