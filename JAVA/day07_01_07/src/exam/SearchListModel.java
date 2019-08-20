package exam;

public class SearchListModel implements MeInter{
	
	public  String exec() {
		StringBuffer str = new StringBuffer();
		str.append("ID : K, age : 10\n");
		str.append("ID : A, age : 20\n");
		str.append("ID : B, age : 30\n");
		return str.toString();
	}

	

}
