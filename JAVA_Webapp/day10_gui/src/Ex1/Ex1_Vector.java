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
    //모든 객체 안에는 object가 들어있다..?
    Vector v = new Vector();
    public Ex1_Vector(Vector v) {
        
        System.out.println("초기 용량"+v.capacity());
        System.out.println("초기 사이즈"+v.size());
        //add를 호출해서 Vector에 저장
        v.add("Test1");
        v.add("Test2");
        v.add("Test1");
        System.out.println("초기 용량"+v.capacity());
        System.out.println("초기 사이즈"+v.size());
        //추천하지 않음
        
        for(int i=0; i<v.size();i++){
            System.out.println(v.get(i));
            
        }
        System.out.println("---------------------------");
        //향상된 for문으로 출력이 가능하다.(권장)
        for(Object e : v){
            System.out.println(e);
        }
        System.out.println("-----------------------");
        
        //반복자 (추천)
        Iterator it = v.iterator();
        while(it.hasNext()){//다음 요소가 있으면 true
            Object o = it.next(); //요소의 값을 가져오는 메서드
            System.out.println(o);
        }
    }

    //모든 클래스는 기본적으로 최상위 클래스인 Object를 상속받는다.
    @Override
    public String toString() {
        return "Ex1_Vector{" + "v=" + v + '}';
    }
    public static void main(String[] args) {
      Vector v1 = new Vector();
      Ex1_Vector v = new Ex1_Vector(v1);
    }
    

}
