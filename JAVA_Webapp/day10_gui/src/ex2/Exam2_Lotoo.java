
package ex2;

import java.util.Scanner;
import javax.imageio.ImageIO;

public class Exam2_Lotoo implements  Exam2_LottoInter{
    Exam1_LottoDemo exam1;
    // �ζ� ��ȣ�� ������ ��ü�� ������.
    public Exam2_Lotoo(){
        exam1=new Exam1_LottoDemo(); 
       
    }
    public static void main(String[] args) {
        Exam2_Lotoo exam2 = new Exam2_Lotoo();
        // �ڱ��ڽ��� ��ü�� ����.
        Scanner sc= new Scanner(System.in);
        //��ĳ�ʸ� ��ü�� ����.
        while(true){
            //������ �ݺ��ϵ��� ����.
            int playnum=0;
            // ���Ӽ��� 0���� �ʱ�ȭ�ص�.
            boolean IsNum=true;
            // ������ ���� �ٽ� �ݾ��� �Է��ϵ��� �ݺ������� �ݾ׹޴ºκ��� ����.
            while(IsNum){
                System.out.print("�ݾ� �Է� :");
                try{
                    int money=Integer.parseInt(sc.nextLine());
                    // ���� �Է¹���.
                    playnum=money/1000;
                    // ���� ���� ��� ������ ���� ����.
                    IsNum=false;
                    // ����� �ݾ��� �Է¹����� �ݺ����� ��������.
                }catch(NumberFormatException e){
                    System.out.println("���ڰ� �ƴմϴ� �ٽ� �Է��ϼ���.");
                }
            }
            if( playnum<=0){
                System.out.println("�ݾ��� �����մϴ�.");
            }else{
                System.out.println("-------������ �ζ� ���� ��ȣ------------");
                exam2.setLottoGameNum(playnum);
            }
            System.out.print("��� �Ͻðڽ��ϱ�? 1.����, �ٸ����Ű.���");
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