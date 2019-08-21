
package ex2;

import java.util.Scanner;
import javax.imageio.ImageIO;

public class Exam2_Lotoo implements  Exam2_LottoInter{
    Exam1_LottoDemo exam1;
    // 로또 번호를 만들어내는 객체를 가져옴.
    public Exam2_Lotoo(){
        exam1=new Exam1_LottoDemo(); 
       
    }
    public static void main(String[] args) {
        Exam2_Lotoo exam2 = new Exam2_Lotoo();
        // 자기자신을 객체로 생성.
        Scanner sc= new Scanner(System.in);
        //스캐너를 객체로 생성.
        while(true){
            //게임을 반복하도록 설정.
            int playnum=0;
            // 게임수를 0으로 초기화해둠.
            boolean IsNum=true;
            // 오류가 나면 다시 금액을 입력하도록 반복문으로 금액받는부분을 설정.
            while(IsNum){
                System.out.print("금액 입력 :");
                try{
                    int money=Integer.parseInt(sc.nextLine());
                    // 돈을 입력받음.
                    playnum=money/1000;
                    // 돈을 통해 몇번 게임을 할지 저장.
                    IsNum=false;
                    // 제대로 금액을 입력받으면 반복문을 빠져나옴.
                }catch(NumberFormatException e){
                    System.out.println("숫자가 아닙니다 다시 입력하세요.");
                }
            }
            if( playnum<=0){
                System.out.println("금액이 부족합니다.");
            }else{
                System.out.println("-------금주의 로또 예상 번호------------");
                exam2.setLottoGameNum(playnum);
            }
            System.out.print("계속 하시겠습니까? 1.종료, 다른모든키.계속");
            String gameendbtn=sc.nextLine();
            if(gameendbtn.equals("1")){
                break;
            }
        }
    }

    @Override
    public String getLottoNum() {
        StringBuffer x=new StringBuffer();
        exam1.returnLotto();
        for (int i : exam1.getS()){
            x.append(i+" ");
        }
        exam1.getS().clear();
        
        return x.toString();
    }

    @Override
    public void setLottoGameNum(int num) {
        for(int i=0;i<num;i++){
            System.out.println("No["+i+"] "+ getLottoNum());
        }
    }
}