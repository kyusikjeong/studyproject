package exam;

import java.util.TreeSet;

public class LottoGame implements LottoInter{
    private String LottoNum;
    private int LottoGameNum;
    
    
    private TreeSet<Integer> ts; //3.����
    public LottoGame(){      //������ ts�� �ش� ��ü�� ����
        ts = new TreeSet<>();
     }
  
     public String getLottoNum() {
         
        return LottoNum;
    }
    public void setLottoGameNum(int num) {
        System.out.println("-----------1");
       int gameCost = 1000;
       int count = num/gameCost;
       int gamecount=0;
       if(count>0){
           while(count>0){
                while(ts.size() != 6){// 6���� ������ ts �� ����
                    int rnum = (int)(Math.random()*45)+1;
                    ts.add(rnum);
                }
                for(int e: ts){
                    System.out.print(e+" ");
                }
                System.out.println();
              ts.clear();
              count--;
          }
       } else {
           System.out.println("�ݾ��� ����");
       }
    }
    
    ///////////////////////////////////////////////////////////////////////////
    
    
    
    public int getLottoGameNum() {
        return LottoGameNum;
    }
    
    
    public void setLottoNum(String LottoNum) {
        this.LottoNum = LottoNum;
    }
}
