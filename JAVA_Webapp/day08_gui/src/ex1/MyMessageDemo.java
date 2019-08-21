package ex1;

public class MyMessageDemo {
    private String message;
    public String makeMessage(String name){
         StringBuffer sb = new StringBuffer();
         sb.append("æ»≥Á«œººø‰. ").append(name).append("¥‘ π›∞©Ω¿¥œ¥Ÿ. \n");
         
         return sb.toString();
    }
    public String makeMessage(String name,boolean gender){
         StringBuffer sb = new StringBuffer();
         if(gender){
            sb.append("1: æ»≥Á«œººø‰. ").append(name).append("¥‘ π›∞©Ω¿¥œ¥Ÿ. \n");
         } else {
            sb.append("2: æ»≥Á«œººø‰. ").append(name).append("¥‘ π›∞©Ω¿¥œ¥Ÿ. \n"); 
         }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        MyMessageDemo mmd = new MyMessageDemo();
        String test =  mmd.makeMessage("adf");
        System.out.println(test);
    }
            
}
