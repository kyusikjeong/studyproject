package exam;

;

public class exam_Logic {
	
	private exam_BoardMember bm;
	public void setMember(exam_BoardMember bm) { //boolean setMember(~) 주고 유효성 체크에서 return false 주는방법도 생각.
		//들어오는 나이값을 판별해서 성년인지 미성년인지 구분하고 미성년이면 데이터를 입력하지 못하도록 구현
		this.bm = bm;
		System.out.println("test");
	}
	public void printMember() {
		String[][] str = bm.getTest();
		int i=0;
	
		Loop:for(String[]out: str) {
				for(String in : out) {
					System.out.println("작성자: "+str[i][0]);
					System.out.println("글제목: "+str[i][1]);
					System.out.println("글내용: "+str[i][2]);
					System.out.println("---------------");
					
					if( i<4) {
						i++;
					} else {
						break Loop;
					}
				}
			
		}
	}
}
