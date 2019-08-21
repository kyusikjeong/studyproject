
package ex1;


public class Ex1_Lambda {
    public static void main(String[] args) {
      
        MyInter myInter = new MyInter(){
            @Override
            public void myMethod(){
                System.out.println("MyTest");
        }
        };
        
       myInter.myMethod();
       System.out.println("-------------------");
       MyInter myInter1;
       //매개변수와 리턴값이 없을경우 람다식
        myInter1 = ()->{
            System.out.println("MyTest1");
        };
        myInter1.myMethod();
        
        System.out.println("-------------------");
    }
}
