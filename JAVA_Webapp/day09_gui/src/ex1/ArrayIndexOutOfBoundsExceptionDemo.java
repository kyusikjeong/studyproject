
package ex1;


public class ArrayIndexOutOfBoundsExceptionDemo {
    public static void main(String[] args) {
        String data1 = args[0];
        String data2 = args[1]; //실행매개값을 주지 않았으므로 배열의 범위를 초과한 것이 되거 예외발생
        
        System.out.println("args[0]:"+ data1); 
        System.out.println("args[1]:"+ data2);
        
    }
}
