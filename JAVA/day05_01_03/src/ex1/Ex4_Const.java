package ex1;

public class Ex4_Const {
	private String msg;
	private int num;
	private Ex4_Const() {
		System.out.println("Test1");
	}
	//생성자의 인자값으로 멤버의 자원을 외부에서 받아와서 초기화함
	//생성자는 여러번 호출하면 여러번 생성된다.
	//생성자를 오버로딩으로 정의가능
	
	public Ex4_Const(String msg, int num) {
		//this:현재 객체의 주소값
		this();
		System.out.println("Test2");
		this.msg = msg;
		this.num = num;
	}
	
	public Ex4_Const(String msg) {
		this.msg = msg;
		num = 10;
	}
	public Ex4_Const(int num) {
		this.num = num;
		msg = "hi";
	}
	
	public void print() {
		System.out.println("MSG: "+msg);
		System.out.println("NUM: "+num);
	}
	
	public static void main(String[] args) {
		Ex4_Const ref1 = new Ex4_Const("hihi"); 
		ref1.print();
		Ex4_Const ref2 = new Ex4_Const(30);
		ref2.print();
		Ex4_Const ref3 = new Ex4_Const("ww", 9);
		ref3.print();
	}
}
