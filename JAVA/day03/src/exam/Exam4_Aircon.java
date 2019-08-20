package exam;

public class Exam4_Aircon {
	
	//
	boolean power;
	boolean temButton;
	
	int temp=16;
	int option=0;
	
	
	public void setPower(boolean p) {
		power = p;
		if (p == true) {
			System.out.println("전원이 켜졌습니다.");
		} else {
			System.out.println("전원이 꺼졌습니다.");
			System.exit(0);
		}
		
	}
	public  void setTemp(boolean t) {
		if(t == true) {
			if(temp < 31 ) {
				temp++;
			}
			System.out.println("상승한 온도는 "+temp+" 도 입니다.");
		} else if (t== false){
			if(temp > 16) {
				temp--;
			}
			System.out.println("감소된 현재 온도는 "+temp+" 도 입니다.");
		}
	}
	public  void setOption(int o) {
		switch(o) {
		case 1: 
			System.out.println("강풍으로 설정하였습니다");
			break;
		case 2:
			System.out.println("약풍으로 설정하였습니다");
			break;
		case 3:
			System.out.println("미풍으로 설정하였습니다");
			break;
		default:
			System.out.println("잘못된 번호입니다.");
			break;
			
		}
	}
	
	
}
