/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ex1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author KOSTA
 */
public class Ex3_ArrayList {
    //���ڿ� ��ü�� ���� �� �ִ� ArrayList
    private ArrayList<String> list;
    //������..
    private ArrayList<Integer> nList;

    
    public Ex3_ArrayList(){
        ArrayList<Member> mList;
        Member member = new Member();
        
        mList = new ArrayList<>();
        //member �����ϱ�
        Member m = new Member();
            
//        for(int i=0; i<3; i++){
//            m.setId("name "+i);
//            new Member()
//            mList.add(new Member().getId());
//        }
        
        for(Member e : mList){
            System.out.println("���̵� "+e.getId());
        }
        
        //jdk7 ���� new ArrayList<����> �̷������� ������ ����
        //jdk6 new ArrayList<String>(); �������� ǥ�⸦ �ݵ�� ���־����
        list = new ArrayList<>();
        list.add("Test12");  //String Ÿ���� ��ü�� ����
        list.add("10");
        list.add("3.14");
        
        nList = new ArrayList<>();
        nList.add(2000);  //Integer Ÿ�� ��ü��...
        nList.add(3000);
        //for������ ����غ���
        
        for(String e : list){
            System.out.println(e);
        }
        System.out.println("-------------------");
        for(Integer e : nList){
            System.out.println(e);
        }
        
        //iterator �� Ÿ���� �ݵ�� �����ؾߵȴ�. �׷��� ������ Object Ÿ�� �����Ͱ� ���� ��
        Iterator<String> it1 = list.iterator(); 
        Iterator<Integer> it2 =  nList.iterator();
        
        while(it1.hasNext()){
            String e =  it1.next();
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
      
        new Ex3_ArrayList();
        ArrayList<Member> mList = new ArrayList<>();
       
        for(int i=0; i<3; i++){
           mList.add(new Member("xman: "+i,"Kim"+i,30+i));
        }
        
        for(Member e : mList){
            System.out.println("id "+e.getId());
            System.out.println("id "+e.getName());
            System.out.println("id "+e.getAge());
        }
        
                                                //����Ʈ���� ���� ������. get�޼ҵ�� ���� ����� �޸� �ּҰ��� �����´�.
                                                //�ּҰ��� ���� �ش� ��ü�� ����� ������ ����������.
        System.out.println("ù���� ���� �̸�  "+mList.get(0).getName());
//       
//        Member member = new Member();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("�̸�");
//        //member.setId(sc.nextLine());
//        String name = sc.nextLine();
//        System.out.println("����");
       
//        member.setAge(sc.nextInt());
//        mList.add(member.getId());
    //    mList.add(member.getAge());
   
//        for(Object e : mList){
//            System.out.println(e);
//        }
       
      
        
//        System.out.println("�̸�");
//        mList.add(sc.nextLine());
//        System.out.println("����");
//        mList.add(sc.nextInt());
        
    }
    
    
}
