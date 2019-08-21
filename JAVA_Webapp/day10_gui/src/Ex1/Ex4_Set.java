package Ex1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class Ex4_Set {
    public static void main(String[] args) {
        //Set 인터페이스. 정렬이 보장되지 않는 중복값을 방지하는 컬렉션
        //중복을 제거 하면서 반복자, 향상된 for문 등을 지원
        
      //  HashSet<String> h1 = new HashSet<>();
         // TreeSet<String> h1 = new TreeSet<>();
        LinkedHashSet<String> h1 = new LinkedHashSet<>();
        h1.add("ZTest");
        h1.add("ATest");
        h1.add("CTest");
        h1.add("ATest"); 
        h1.add("GTest");
        System.out.println("크기"+h1.size());
        for(String e: h1){
            System.out.println(e);
        }
        
        System.out.println("-------------------------------");
        Iterator<String> it =  h1.iterator();
        
        while(it.hasNext()){
            String e =  it.next();
            System.out.println(e);
        }
    }
}
