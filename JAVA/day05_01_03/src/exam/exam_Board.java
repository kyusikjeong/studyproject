package exam;

import java.util.Scanner;

public class exam_Board {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		String[][] str = new String[5][3];
		int i=0;
		exam_Logic logic = new exam_Logic();
		
		while(true) {
			
			System.out.println("1.�� �ۼ�  2.���  3.����");
			int menu=Integer.parseInt(sc.nextLine());;
			
			String name="";
			String title = "";
			String content = "";
			
			if(menu == 1) {
			Loop: for(String[] out: str) {
					for(String in: out) {
						System.out.println("�ۼ��� : ");
						name = sc.nextLine();
						System.out.println("������ : ");
						title = sc.nextLine();
						System.out.println("�۳��� : ");
						content= sc.nextLine();
						
						str[i][0] = name;
						str[i][1] = title;
						str[i][2] = content;
						
						exam_BoardMember set = new exam_BoardMember();
						if( i<4) {
							i++;
						} else {
							set.setTest(str);
							logic.setMember(set);
							break Loop;
						}
						
					}
				}
			} else if(menu == 2) {
				logic.printMember();
			} else if(menu ==3) {
				break;
			}
		}
		
	}
}
