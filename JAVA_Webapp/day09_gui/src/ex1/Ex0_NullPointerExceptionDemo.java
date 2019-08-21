package ex1;
import ex1.MyInter;


public class Ex0_NullPointerExceptionDemo {
    private MyInter inter;
    
    public Ex0_NullPointerExceptionDemo(MyInter inter) {
        this.inter = inter;
    }
    public void execute(){
        inter.myMethod();
    }
    
    public static void main(String[] args) {
        MyInter inter = null;
        new Ex0_NullPointerExceptionDemo(inter).execute();
    }
    
}
