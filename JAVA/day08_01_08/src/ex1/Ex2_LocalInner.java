package ex1;

//���� ����Ŭ����: �޼���. ������ �����ȿ��� ����
//���ÿ��� ����ǰ� ������ ������ ���������� �����Ѵ�.


public class Ex2_LocalInner {
	private int a;
	public Ex2_LocalInner() { a=100;}
	//���� ����Ŭ���� �ȿ���...�������� �̾߱�
	//jdk 7���ϱ����� final�̶�� ���
	//8���� ���ĺ��ʹ� final �� ��� ���������� ��� ���
	public void insertTest(int num) {
		int b = 200;
		int c = num;
		
			class Inner{//�޼ҵ� ���� �ȿ� ����
				public void getData() {
					System.out.println("����ʵ� ���� :"+a);
					//�޼��� ���� ����� ������ �� ������
					//���������� ���� �� ����.
//					System.out.println("�������� ����"+(b++));
//					System.out.println("��������?"+(c+=num));
//					System.out.println(b);  //���������� ������ ������ �ȵ�.1
				}
			}
			
			new Inner().getData();
			b = 30;  //�����ϸ� 1���� ���ٰ���.
			System.out.println("b: "+b);
	}
	public static void main(String[] args) {
		new Ex2_LocalInner().insertTest(200);
	}
	
}
