/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KOSTA
 */
public class Ex1_FileReWriteMain {
    private Ex1_FileReWrDemo efr;           //��ü ���� �� �ش� �ּҸ� ����ϱ� ���� �ʵ忡 ����
    
    public Ex1_FileReWriteMain (){
        efr = new Ex1_FileReWrDemo();  //��ü ����.
    }

    public void execWriter(String memo){     //�Է��� ���� 
        efr.writeMemo(memo);
    }
    public void execReader(){
        try {
            ArrayList<String> arlist = efr.getMemo();
            for (String e : arlist){
                System.out.println(e);
             }
        } catch (IOException ex) {
           ex.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("memo: ");
        Ex1_FileReWriteMain mains = new Ex1_FileReWriteMain();
        mains.execWriter(sc.nextLine());
        mains.execReader();
    }
    
}
