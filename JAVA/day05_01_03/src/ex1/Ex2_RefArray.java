package ex1;

public class Ex2_RefArray {
	
	Ex2_RefArray() {  //�迭�� ��ü�̴�.
		String [] str;
		str = new String[5];
	
		str[0] = "kosta188";
		str[1] = new String("kosta188");
		str[2] = new String("kosta188");
		str[3] = "kosta188";
		str[4] = "test";
		
		for(String e:str) {
			System.out.println(e);
			
		}
		System.out.println("Length: "+str.length);
		System.out.println("-------------------");
		System.out.println("�ּҰ� ��1: "+(str[0]==str[3]));
		System.out.println("�ּҰ� ��2: "+(str[1]==str[2]));
		
	}
	public static void main(String[] args) {
		new Ex2_RefArray();
	}
	
}
