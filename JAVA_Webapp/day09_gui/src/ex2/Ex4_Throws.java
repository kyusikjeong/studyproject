package ex2;


//throws는 예외를 호출한 쪽으로 위임함
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
            System.out.println("실행!");
        }
}

