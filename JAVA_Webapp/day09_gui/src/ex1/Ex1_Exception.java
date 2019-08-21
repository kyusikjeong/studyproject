package ex1;

import java.util.Scanner;

public class Ex1_Exception {
    public static void main(String[] args) {
        System.out.println("수를 입력  ");
        int num = 0;
        int res = 0;
        
        Scanner sc = new Scanner(System.in);
        try{
            num = Integer.parseInt(sc.nextLine());//예외가 발생
            res = 10/num; //예외발생
            System.out.println("Res"+res);//예외발생시 실행이 안됨
        }
//        }catch(NumberFormatException e) { //숫자가 아닌값이 들어왔을시 발생
//            System.out.println("숫자만 입력하세요.");
//            
//        }catch(ArithmeticException e){  //0으로 값을 나누려고 할 시
//            System.out.println("0으로 나눌 수 없습니다");
//        }
        catch(Exception e){
            //e에는 예외의 처리 객체의 주소값
            System.out.println("나머지 예외");
           
           if(e instanceof NumberFormatException){
               System.out.println("숫자만 입력하세요.");
           } else if(e instanceof ArithmeticException){
               System.out.println("0으로 나눌 수 없습니다");
           }
            
        }
          System.out.println("실행 종료. 마무리 영역");
    }
 //  catch(NumberFormatException  | ArithmeticException e) 이런식으로 처리도 가능하다.
      
}