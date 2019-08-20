package exam;


// 1.순수한 값만을 가지는 객체
// 분석 -> 설계( 만들어지거나, 제작)
// 2.데이터베이스 설계시 엔티티로 바로 제작가능!
// 자동으로 만들지만, 항상 손이 간다. 
public class exam_Setget {
// 회원의 정보를 저장
	//멤버필드, 지역변수 =>반드시 소문자로 작성해서... 명명규칙 복습
	private int num; //회원번호
	private int age;
	private String name, id;//회원의 정보들
	private boolean agree;// 동의 여부
	
	//setter /getter로 메서드를 제공한다.
	// Alt + shift + s -> setter /getter generate
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	//boolean형의 getter이다. ************
	public boolean isAgree() {
		return agree;
	}//*********************************
	public void setAgree(boolean agree) {
		this.agree = agree;
	}
	
	
	
}
