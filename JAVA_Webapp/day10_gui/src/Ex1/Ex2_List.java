/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 *
 * @author KOSTA
 */
public class Ex2_List {
    private List list;
    public Ex2_List(){
        list = new ArrayList();
        list.add("StringAAA");
        list.add(new Integer(30));
        list.add(new Character('A'));
        list.add(new Float(3.14f));
        list.add("String");
        
        System.out.println("Size"+list.size());
        Iterator it = list.iterator();
        
        
        //collection �� Object type�� ���� ��õ���� ������
        //jdk5 ���� ���׸����� ����Ѵ�.********
        for(Object e : list){
            if( e instanceof String){
                System.out.println("String"+e);
            } //......
            String obj = e.getClass().getCanonicalName(); //Ŭ������ ��Ȯ�� �̸��� ����
            System.out.print(obj.substring(obj.lastIndexOf(".")+1)+":"); //������ ������ �ε���
            System.out.println(e);
         }
        //----------------------------------------
     }
    
    public static void main(String[] args) {
        Ex2_List e = new Ex2_List();
       
        
    }
}
