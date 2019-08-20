package exam;

public class exam_BoardMember {
	String title,name,contents;
	
	String date;
	String [][] str;
	public void setTest(String[][] tt){
		this.str = tt;
//		for(String[]out: tt) {
//			for(String in : out) {
//				System.out.println(in);
//			}
//		}
	
	}
	
	public String[][] getTest() {
		return str;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
}
