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
public class GameData {
    private int totalGameCount;
    private int winCount;
    private final int gameCost = 500;
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
    public int getGameCost() {
        return gameCost;
    }
    
    public int getTotalGameCount() {
        return totalGameCount;
    }

    public void setTotalGameCount() {
        this.totalGameCount++;
    }
    public void setTotalGameCount(int i) {
        totalGameCount = i;
    }

    public int getWinCount() {
        return winCount;
    }

    public void setWinCount() {
        this.winCount++;
    }
    public void setWinCount(int i) {
        winCount = i;
    }

  
    
}
