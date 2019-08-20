package exam;

public class MyService{
	
	MeInter mi;
	public MyService(){
	
	}


	public void service(String cmd) {
		if(cmd.equals("1")) {
			mi = new SearchListModel();
			System.out.println(mi.exec());
		} else {
			mi = new SelectViewModel();
			System.out.println(mi.exec());
		}
	}
}
