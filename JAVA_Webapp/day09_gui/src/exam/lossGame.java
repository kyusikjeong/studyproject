/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author KOSTA
 */
public class lossGame implements GameInter {
    int gameCost = 500;
 
    @Override
    public void winRate(String name, int money, int user,GameData gData) {
        int money1 = gData.getMoney();
        
        if(money1>=500){
            money1 -= gameCost;
            gData.setMoney(money1);
            gData.setTotalGameCount();
            
        } else if(money1 < 500){
              GameMessage gm  = new GameMessage(gData);
              System.out.println("금액이 부족합니다.");
              System.out.println(gm.print());
              System.exit(0);
        }
        
    }
}
