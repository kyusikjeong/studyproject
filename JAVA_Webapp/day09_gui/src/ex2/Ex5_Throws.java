package ex2;

public class Ex5_Throws {
    //����ȸ��
    public static void main(String[] args) {
        try{
            execute(0);
            
        }catch(Exception e){
            System.out.println("�츮ȸ�� ǥ����!");
            
        }
    }
    
    //�츮ȸ�� ����Ʈ�� �ڵ常 ����!
    
    private static void execute(int num) throws ArithmeticException{
        int nums= 10/num;
        System.out.println("nums!"+nums);
    }
}
