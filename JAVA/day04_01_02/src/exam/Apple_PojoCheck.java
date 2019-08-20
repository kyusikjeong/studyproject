package exam;

public class Apple_PojoCheck {
	//유효성검사. 비즈니스 로직. 선별등의 기능을 담당.
	private Apple_Pojo ap;
	
	public void setCheck(Apple_Pojo ap) {
		if (ap.getType().equals("사과")) {
			this.ap = ap;
		} else {
			System.out.println("사과만 검사 할 수 있습니다.");
		}
	}
	
	public void printCheck() {
		if(ap != null) {
			
			int size = ap.getSize();
			String apSize = "";
			if(10<= size && size <20) {
				apSize = "중";
			} else if(20<=size && size <30) {
				apSize = "상";
			} else if(30<=size) {
				apSize = "특";
			}
			
			int status = ap.getStatus();
			String aStatus = "";
			
			if(status ==1) {
				aStatus = "정상";
			} else if(status ==2) {
				aStatus = "흠이 있음";
			} else if(status ==3) {
				aStatus = "판매불가";
			}
			
			
			System.out.println("사과의 원산지는 "+ap.getOrigine() +" 입니다.");
			System.out.println("사과의 상태는 "+aStatus+" 입니다.");
			System.out.println("사과의 크기는 "+apSize+" 입니다.");
			
		}
	}

}
