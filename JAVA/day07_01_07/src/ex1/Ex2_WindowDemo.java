package ex1;

public abstract class Ex2_WindowDemo extends Ex2_AbstractVal{
	
	abstract public void exec1();
	//비어있는 메서드를 정의한다. 엠퍼티 메서드? 쓰고싶은거만 골라 구현할떄....
	//추상메서드를 직접 익명 내부 클래스로 재정의 하는 경우도 알아보자.
	// new Ex2_WindowDemo(){  대충 예제;
	//  @Override
//		public void exec1() {
//			System.out.println("다른방법");
//		}
//		}.exec1();
	@Override  //없어도 되지만 있음으로써 프로그램이 점검을 해줌 
	public void exec2() {
		
	}
	@Override
	public void exec3() {
		
	}
	@Override
	public void exec4() {
		
	}
	@Override
	public void exec5() {
		
	}

}
