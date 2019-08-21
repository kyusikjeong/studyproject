package ex2;
public class Ex3_Exception {
    private int[] var = {100,200,300};
    public Ex3_Exception() {
        try{
            for(int i=0; i<=var.length; i++){
                System.out.println(i+ ""+ var[i]);
            }
        } catch(Exception e){
            //예외의 메세지를 출력
            e.printStackTrace();
            System.out.println("배열의 범위를 넘었습니다");
            return;
        }finally{
            //예외 처리와 상관없이 무조건 수행이 되는 영역
            System.out.println("실행 종료! finally 마무리 영역");
        }
       //System.out.println("실행 종료! finally 마무리 영역");
    }
    
    public static void main(String[] args) {
        new Ex3_Exception();
    }
}
