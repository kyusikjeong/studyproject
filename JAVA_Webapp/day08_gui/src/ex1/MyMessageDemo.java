package ex1;

public class MyMessageDemo {
    private String message;
    public String makeMessage(String name){
         StringBuffer sb = new StringBuffer();
         sb.append("�ȳ��ϼ���. ").append(name).append("�� �ݰ����ϴ�. \n");
         
         return sb.toString();
    }
    public String makeMessage(String name,boolean gender){
         StringBuffer sb = new StringBuffer();
         if(gender){
            sb.append("1: �ȳ��ϼ���. ").append(name).append("�� �ݰ����ϴ�. \n");
         } else {
            sb.append("2: �ȳ��ϼ���. ").append(name).append("�� �ݰ����ϴ�. \n"); 
         }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        MyMessageDemo mmd = new MyMessageDemo();
        String test =  mmd.makeMessage("adf");
        System.out.println(test);
    }
            
}
