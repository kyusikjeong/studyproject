package ex2;

public class Ex2_Exception {
    public static void main(String[] args) {
        try{
            //�����Ͻ� ���ܴ� �ַ� ��ġ��, �ܺ� ����̹� ����
            //�����Ϸ��� �����ϴ� �����̴�.
            Thread.sleep(5000);
            System.out.println("Test");
        } catch (InterruptedException ex){
            //���ܰ� �߻����� �� �����ڰ� Ȯ�� �� �� �ִ� �޼���
            ex.printStackTrace();
        }
    }
}
