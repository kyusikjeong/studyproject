/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.util.Scanner;

/**
 *
 * @author KOSTA
 */
public class GameService {
    GameData gData = new GameData();
    GameInter gInter;
    GameMessage gm;
   
    
    public int totalCount;
    public int winCount;
    public GameService(int m){
        gData.setMoney(m);
    }
    public GameData getGameData(){
        return gData;
    }
    public void service(String name, int money,int user){
        Scanner sc= new Scanner(System.in);
        float winRate;
        
        totalCount =gData.getTotalGameCount();
        winCount = gData.getWinCount();
         gm = new GameMessage(gData);    
        int cpu = (int)(Math.random()*2)+1;
        if(user == 3) {
          
            winRate = (float)winCount/ totalCount*100;
            
            System.out.println(gm.print());
            if(winRate>=70) {
                    System.out.println("�·��� 70% �̻��Դϴ�. ��ǰ �޾ư�����.");
                    System.exit(0);
            } else {
                    System.out.println("��. ���� ��ȸ��...");
                    System.exit(0);
            }
				//�·��̶� 7�� �̻� ��ǰ ���� �ؽ�Ʈ ���
        }
        if (user == cpu){
          System.out.println("win");
          gInter = new winGame();
          gInter.winRate(name, money, user,gData);
         }else if(user != cpu){
          System.out.println("loss");
          gInter = new lossGame();
          gInter.winRate(name, money, user,gData);
          
         }


        }
    
     }

       
 
