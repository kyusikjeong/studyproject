package ex1;

public class Ex5_Const {
	public Ex5_Const() {
		this("test");  //1.기본 생성자를 수행하러 왔더니 String 매개변수로 갖는 생성자 호출
		System.out.println("aa");
	}
	public Ex5_Const(String msg) {
		this(true);		//2.boolean 매개변수로 갖는 생성자 호출
		System.out.println("bb");
	}
	public Ex5_Const(float f) {
		this(10);		//4.int 매개변수로 갖는 생성자 호출
		System.out.println("cc");
	}
	public Ex5_Const(int n) {
						//5. 실행.
		System.out.println("dd");
	}
	public Ex5_Const(boolean b) {
		this(3.14f);	//3.float 매개변수로 갖는 생성자 호출
		System.out.println("ee");
	}
	
	public static void main(String[] args) {
		new Ex5_Const(); //기본 생성자 호출
		
	}
}
