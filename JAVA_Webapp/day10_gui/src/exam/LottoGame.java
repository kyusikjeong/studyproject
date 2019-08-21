package exam;

import java.util.TreeSet;

public class LottoGame implements LottoInter{
    private String LottoNum;
    private int LottoGameNum;
    
    
    private TreeSet<Integer> ts; //3.선언
    public LottoGame(){      //선언한 ts에 해당 객체를 생성
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
                while(ts.size() != 6){// 6개의 난수를 ts 에 저장
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
           System.out.println("금액이 부족");
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
