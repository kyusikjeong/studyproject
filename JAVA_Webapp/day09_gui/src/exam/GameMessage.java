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
            
            sb.append("service ------"+tc+"\n").append("*****************************"+"\n").append("���� ����! \n")
              .append("��ü ���Ӽ�: "+tc+"\n").append("�̱� Ƚ��: "+wc+"\n")
              .append("�·�: "+(int)winRate+"% \n").append("*****************************"+"\n");
           return sb.toString();
    }
}
