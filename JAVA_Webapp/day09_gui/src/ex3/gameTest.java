package ex3;

import java.util.Scanner;

public class gameTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int winCount =0;
		int count = 0;
		float winRate;
		
		for(;;) {
			
			System.out.println("�޴� 1 - Ȧ, 2 - ¦ , 3- ����");
			String menu = sc.nextLine();
			String user= "";
			
			if (menu.equals("2")){
				user = "¦";
			} else if (menu.equals("1")){
				user = "Ȧ";
			} else {
				System.out.println("��Ȯ�� ���� �Է��Ͽ� �ֽʽÿ�.");
			}
			
			int cpu = (int)(Math.random()*2);
			String cpuT = (cpu% 2 ==0) ? "¦" : "Ȧ";
			
			if (menu.equals("3")) {
				
				//winRate = Math.round((float)winCount / count*100);  //�ݿø� �ʿ��� ��.
				winRate = (float)winCount / count*100;
				System.out.println("*****************************");
				System.out.println("���� ����!");
				System.out.println("��ü ���Ӽ�: "+count);
				System.out.println("�̱� Ƚ��: "+winCount);
				System.out.println("�·�: "+(int)winRate+"%");
				System.out.println("*****************************");
				
				if(winRate>=70) {
					System.out.println("�·��� 70% �̻��Դϴ�. ��ǰ �޾ư�����.");
				} else {
					System.out.println("��. ���� ��ȸ��...");
				}
				break;
				//�·��̶� 7�� �̻� ��ǰ ���� �ؽ�Ʈ ���
			
			}
			if (user.equals(cpuT)) {
					winCount++;
					count++;
					System.out.println("-------------------------");
					System.out.println("No: "+count);
					System.out.println("CPU: "+cpuT);
					System.out.println("YOU: "+user);
					System.out.println("WIN");
				
			} else {
				count++;
				System.out.println("-------------------------");
				System.out.println("No: "+count);
				System.out.println("CPU: "+cpuT);
				System.out.println("YOU: "+user);
				System.out.println("LOSE");
				
			}
			
		}
		
		
		
		
		
		
		
//		
//		
//		public static void count(String user,String cpuT,int count) {  //�޼���� �����ָ� �ڵ尡 �پ�����
//			System.out.println("-------------------------");
//			System.out.println("No: "+count);
//			System.out.println("CPU: "+cpuT);
//			System.out.println("YOU: "+user);
//		}
	}
}