package Ex1;


public class Ex3_Wrapper_AutoBoxing {
    public static void main(String[] args) {
        String str = new String("���ڿ�");
        String str2 = "���ڿ�";
//        int b=0;
//        Integer c = b;
//        new Integer(b);
        //Wrapper Ŭ����. 
        //Integer num = new Integer("100");
        //autoboxing : ��ü�� ��ȯ
        Integer num = 100;
        //unboxing: Wrapper Ŭ������ �Ϲ� �ڷ������� ��ȯ
        int num3 =  num;
        int num2 = (int)num.longValue();
        System.out.println(num+""+num2);    
    }
}
