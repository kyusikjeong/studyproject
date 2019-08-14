package ex2;

public class Ex7_If {
	public static void main(String[] args) {
		/*
		 * 조건에 만족하지 못하면 If 문은 실행되지 않는다.
		 * 그러나 else 를 정의해두면 그 외의 조건을 모두 실행시킬 수 있다.
		 * if(조건){실행문1:}else{실행문2:}
		 */
		int num = 10;
		int v;
		if (num ==10) {
			//컴파일러가 if 문은 수행이 안될 수도 있다고 인지해서 if에만 초기화 하면 오류남.
			//따라서 else 에도 초기화 해줘야함. (디폴트로)
			v = 10;
			System.out.println(num+"월의 꽃");
		} else {
			v = 20;
			System.out.println(num+"월의 꽃");
		}
		
		System.out.println(v+"");
	}
}
