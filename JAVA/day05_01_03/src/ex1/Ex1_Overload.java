package ex1;

public class Ex1_Overload {
		public void drawCircle(int r) {
			System.out.println("������ "+r+"�� ���� �׸���");
			
		}
		public void drawRec(int w, int h) {
			System.out.println("�ʺ� "+w+", ����: "+h+"�� �簢���� �׸���. ");
			
		}
		public void lineDraw(int x, int y, int len) {
			System.out.println("��ǥ x: "+x+"��ǥ y:"+y);
			System.out.println("���̰� "+len+"�� ���� �׸���.");
			
			
		}
		
		public static void main(String[] args) {
			Ex1_Overload ref = new Ex1_Overload();
			ref.lineDraw(10, 20, 30);
			
			ref.draw(20);
			ref.draw(20, "��~��");
			ref.draw(10, 20, 300);
			//ref.d
		}
		
		
		//�޼ҵ� �����ε�: �޼ҵ��� �̸��� ���� �ص����ν�
		//�޼ҵ��� �������� �ϰ����� �����Ѵ�.
		
		public void draw(int r) {
			System.out.println("������ "+r+"�� ���� �׸���");
		}
		public void draw(int w,String h) {
			System.out.println("�ʺ� "+w+", ����: "+h+"�� �簢���� �׸���. ");
		}
		public void draw(String a,int b) {
			System.out.println("�ʺ� "+a+", ����: "+b+"�� �簢���� �׸���. ");
		
		}
		public void draw(int x, int y, int len) {
			System.out.println("��ǥ x: "+x+"��ǥ y:"+y);
			System.out.println("���̰� "+len+"�� ���� �׸���.");
		}
		
		
		
	}

