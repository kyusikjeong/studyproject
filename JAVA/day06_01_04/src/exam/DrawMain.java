package exam;

public class DrawMain {
	
	
	public static void main(String[] args) {
	
		Draw[] draw = new Draw[3];
		draw[0] =  new Rect();
		draw[1] =  new Triagle();
		draw[2] =  new Circle();
		
		for(Draw arr:draw) {
			
			arr.draw();
			System.out.println(draw[1]);
		}
		
	}
}
