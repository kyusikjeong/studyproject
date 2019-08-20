package exam;

public class exam_DogDemoMain {
	public static void main(String[] args) {
		exam_DogDemo dog = new exam_DogDemo();
		
		dog.dname = "해피";
		dog.dage = 5;
		
		System.out.println("강아지 이름은 "+dog.dname+" 입니다");
		System.out.println("나이는 올해로 "+dog.dage+"살이 되었습니다.");
	}
}
