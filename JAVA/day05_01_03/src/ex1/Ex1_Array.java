package ex1;

public class Ex1_Array {
//	int[] num1 = > �迭�� ����
//	int[] num1 = new int[3]://������ �迭�� ũ�Ⱑ �ʿ�
//	�迭�� ����� ������ �ʱ�ȭ�� ���ÿ�
	
	private int[] num1 = {1,2,3,4,5,6,7,8};
	public Ex1_Array() {
		//�迭�� �ε����� 0 ���� ������ ��
		System.out.println("�迭�� �ε����� ����"+ num1[0]);
		System.out.println("�迭�� ����"+num1.length);
		System.out.println("---------------------");
		
		
		
		for(int i=0; i<num1.length;i++) { //�����迭�� ����� �޸� ���� �ʷ��� �� �ֱ� ������ jdk 5 ���ʹ� �Ʒ��� ���� for ���� ����ϴ°� ����.
	
			System.out.println(num1[i]+"��");
		}
		
		//���� for ��
		for(int e:num1) {
			System.out.println(e+"��");
		}
	}
	
	public static void main(String[] args) {
		Ex1_Array arr = new Ex1_Array();
		
		String [] str;
		str = new String[5];
		
		str[0] = "kosta188";
		str[1] = new String("kosta188");
		str[2] = new String("kosta188");
		str[3] = "kosta188";
		str[4] = "test";
		
		System.out.println("1   :"+(str[0]==str[1]));
		System.out.println("2   :"+(str[1]==str[2]));
		System.out.println("3   :"+(str[0]==str[3]));
		System.out.println("4   :"+(str[0]==str[4]));
		

		
		
		
		
	}
}
