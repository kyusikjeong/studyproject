/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author neo
 */

public class GameMessage{
    private GameData gd;
    public GameMessage(GameData gd){
        this.gd = gd;
    }
    public String print(){
            StringBuffer sb = new StringBuffer();
            int tc = gd.getTotalGameCount();
            int wc = gd.getWinCount();
            float winRate;
            winRate = (float)wc/ tc*100;
            
            sb.append("service ------"+tc+"\n").append("*****************************"+"\n").append("게임 종료! \n")
              .append("전체 게임수: "+tc+"\n").append("이긴 횟수: "+wc+"\n")
              .append("승률: "+(int)winRate+"% \n").append("*****************************"+"\n");
           return sb.toString();
    }
}
