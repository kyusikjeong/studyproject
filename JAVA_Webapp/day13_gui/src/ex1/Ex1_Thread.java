
package ex1;

public class Ex1_Thread extends Thread{
    private int value;

    @Override
    public void run() {
        int i =0;
        String name = Thread.currentThread().getName();
        while(i < 3){
            System.out.println(name + ",지역변수 i 값 : "+(++i));
            System.out.println(name + ",멤버필드 value 값 : "+(++value));
          //  System.out.println("Thread Active Cnt : "+Thread.activeCount());  //현재 활성화 되어있는 스레드의 수
        }
    }
    public static void main(String[] args) {
        Ex1_Thread r = new Ex1_Thread();
        Ex1_Thread r1 = new Ex1_Thread();
        r.start();
        r1.start();
//        new Thread(r).start();
//        new Thread(r).start();
    }
    
}
