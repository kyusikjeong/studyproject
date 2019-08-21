package exam;

import java.util.Scanner;

public class Service {
	
	public String service(String name, String menu) { //main에서 입력받은 값으로 메소드 실행.
            StringBuffer sb = new StringBuffer();
                if(menu.equals("1")) {
			sb.append(new KoreaFood().food(name)); //전달받은 메뉴번호로 국가를 분류하고 주문자 이름을 전달한다.
		}else if(menu.equals("2")){
			sb.append(new IndoFood().food(name));
		}else if(menu.equals("3")){
                        sb.append(new ChiFood().food(name));
                }
            return sb.toString();   //최종적으로 주문 내역을 출력하기 위해 stringbuffer 에 더한 뒤 리턴한다.
	}
}
