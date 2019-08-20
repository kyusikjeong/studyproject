package ex1;

public class Ex3_Main {
	public static void main(String[] args) {
		Ex3_ClassDemo ref = new Ex3_ClassDemo();
		//ref.pay = 10000;
		ref.insertPay(10000,"1");
		
		System.out.println("입력한 Pay 값 : "+ref.viewPay());
	}
}
