package ex1;

import java.util.Scanner;

public class Ex1_Exception {
    public static void main(String[] args) {
        System.out.println("���� �Է�  ");
        int num = 0;
        int res = 0;
        
        Scanner sc = new Scanner(System.in);
        try{
            num = Integer.parseInt(sc.nextLine());//���ܰ� �߻�
            res = 10/num; //���ܹ߻�
            System.out.println("Res"+res);//���ܹ߻��� ������ �ȵ�
        }
//        }catch(NumberFormatException e) { //���ڰ� �ƴѰ��� �������� �߻�
//            System.out.println("���ڸ� �Է��ϼ���.");
//            
//        }catch(ArithmeticException e){  //0���� ���� �������� �� ��
//            System.out.println("0���� ���� �� �����ϴ�");
//        }
        catch(Exception e){
            //e���� ������ ó�� ��ü�� �ּҰ�
            System.out.println("������ ����");
           
           if(e instanceof NumberFormatException){
               System.out.println("���ڸ� �Է��ϼ���.");
           } else if(e instanceof ArithmeticException){
               System.out.println("0���� ���� �� �����ϴ�");
           }
            
        }
          System.out.println("���� ����. ������ ����");
    }
 //  catch(NumberFormatException  | ArithmeticException e) �̷������� ó���� �����ϴ�.
      
}