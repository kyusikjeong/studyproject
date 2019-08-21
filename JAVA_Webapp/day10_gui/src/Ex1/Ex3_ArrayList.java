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
    //문자열 객체만 담을 수 있는 ArrayList
    private ArrayList<String> list;
    //정수만..
    private ArrayList<Integer> nList;

    
    public Ex3_ArrayList(){
        ArrayList<Member> mList;
        Member member = new Member();
        
        mList = new ArrayList<>();
        //member 생성하기
        Member m = new Member();
            
//        for(int i=0; i<3; i++){
//            m.setId("name "+i);
//            new Member()
//            mList.add(new Member().getId());
//        }
        
        for(Member e : mList){
            System.out.println("아이디 "+e.getId());
        }
        
        //jdk7 부터 new ArrayList<생략> 이런식으로 생략이 가능
        //jdk6 new ArrayList<String>(); 형식으로 표기를 반드시 해주어야함
        list = new ArrayList<>();
        list.add("Test12");  //String 타입의 객체만 넣음
        list.add("10");
        list.add("3.14");
        
        nList = new ArrayList<>();
        nList.add(2000);  //Integer 타입 객체만...
        nList.add(3000);
        //for문으로 출력해보기
        
        for(String e : list){
            System.out.println(e);
        }
        System.out.println("-------------------");
        for(Integer e : nList){
            System.out.println(e);
        }
        
        //iterator 에 타입은 반드시 정의해야된다. 그렇지 않으면 Object 타입 데이터가 들어가게 됨
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
        
                                                //리스트에서 값을 꺼내옴. get메소드로 값이 저장된 메모리 주소값을 가져온다.
                                                //주소값을 통해 해당 객체의 멤버에 접근이 가능해진다.
        System.out.println("첫번재 슬롯 이름  "+mList.get(0).getName());
//       
//        Member member = new Member();
//        Scanner sc = new Scanner(System.in);
//        System.out.println("이름");
//        //member.setId(sc.nextLine());
//        String name = sc.nextLine();
//        System.out.println("나이");
       
//        member.setAge(sc.nextInt());
//        mList.add(member.getId());
    //    mList.add(member.getAge());
   
//        for(Object e : mList){
//            System.out.println(e);
//        }
       
      
        
//        System.out.println("이름");
//        mList.add(sc.nextLine());
//        System.out.println("나이");
//        mList.add(sc.nextInt());
        
    }
    
    
}
