package ex2;
public class Ex3_Exception {
    private int[] var = {100,200,300};
    public Ex3_Exception() {
        try{
            for(int i=0; i<=var.length; i++){
                System.out.println(i+ ""+ var[i]);
            }
        } catch(Exception e){
            //������ �޼����� ���
            e.printStackTrace();
            System.out.println("�迭�� ������ �Ѿ����ϴ�");
            return;
        }finally{
            //���� ó���� ������� ������ ������ �Ǵ� ����
            System.out.println("���� ����! finally ������ ����");
        }
       //System.out.println("���� ����! finally ������ ����");
    }
    
    public static void main(String[] args) {
        new Ex3_Exception();
    }
}
