package ex2;


//throws�� ���ܸ� ȣ���� ������ ������
public class Ex4_Throws {
    public static void main(String[] args) {
        try{
            execute();
        } catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }
        
        private static void execute() throws InterruptedException{
            Thread.sleep(1000);
            System.out.println("����!");
        }
}

