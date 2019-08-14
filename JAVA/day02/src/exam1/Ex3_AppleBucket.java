package exam1;

import java.util.Scanner;

public class Ex3_AppleBucket {
//바구니 최대 갯수는 10개. 10개를 초과하면 초과한갯수를 밑에 출력해준다.
	public static void main(String[] args) {
		
		
		exam();
	}
	public static void exam() {
		//삼항 연산자를 사용해서 바구니의 수를 구한다.
		Scanner sc = new Scanner(System.in);
		System.out.print("사과의 갯수를 입력하세요 :");
		int app = Integer.parseInt(sc.nextLine());
		
		int basket = 10;
		int maxBasket = 10;
		int basketNum = app / maxBasket+ (app% maxBasket == 0 ? 0:1);
	
		
		
		if (basketNum>maxBasket) {
			System.out.println("바구니의 수가 초과되었습니다. 바구니의 갯수는 최대 10개 입니다.");
			System.out.println("*****************************");
			System.out.println("필요한 바구니의 값: "+ basketNum);
		} else {
			System.out.println("바구니의 갯수: "+ basketNum);
		}
		// int basket number = app /  maxBasket+(app % maxBasket == 0? 0:1);
		
		
	}
}
