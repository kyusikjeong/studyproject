package Ex1;


public class Ex3_Wrapper_AutoBoxing {
    public static void main(String[] args) {
        String str = new String("문자열");
        String str2 = "문자열";
//        int b=0;
//        Integer c = b;
//        new Integer(b);
        //Wrapper 클래스. 
        //Integer num = new Integer("100");
        //autoboxing : 객체로 전환
        Integer num = 100;
        //unboxing: Wrapper 클래스를 일반 자료형으로 전환
        int num3 =  num;
        int num2 = (int)num.longValue();
        System.out.println(num+""+num2);    
    }
}
