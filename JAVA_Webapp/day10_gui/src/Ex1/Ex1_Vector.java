/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.Iterator;
import java.util.Vector;

/**
 *
 * @author KOSTA
 */
public class Ex1_Vector {
    //��� ��ü �ȿ��� object�� ����ִ�..?
    Vector v = new Vector();
    public Ex1_Vector(Vector v) {
        
        System.out.println("�ʱ� �뷮"+v.capacity());
        System.out.println("�ʱ� ������"+v.size());
        //add�� ȣ���ؼ� Vector�� ����
        v.add("Test1");
        v.add("Test2");
        v.add("Test1");
        System.out.println("�ʱ� �뷮"+v.capacity());
        System.out.println("�ʱ� ������"+v.size());
        //��õ���� ����
        
        for(int i=0; i<v.size();i++){
            System.out.println(v.get(i));
            
        }
        System.out.println("---------------------------");
        //���� for������ ����� �����ϴ�.(����)
        for(Object e : v){
            System.out.println(e);
        }
        System.out.println("-----------------------");
        
        //�ݺ��� (��õ)
        Iterator it = v.iterator();
        while(it.hasNext()){//���� ��Ұ� ������ true
            Object o = it.next(); //����� ���� �������� �޼���
            System.out.println(o);
        }
    }

    //��� Ŭ������ �⺻������ �ֻ��� Ŭ������ Object�� ��ӹ޴´�.
    @Override
    public String toString() {
        return "Ex1_Vector{" + "v=" + v + '}';
    }
    public static void main(String[] args) {
      Vector v1 = new Vector();
      Ex1_Vector v = new Ex1_Vector(v1);
    }
    

}
