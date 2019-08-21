package ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Ex1_Map {
    public static void main(String[] args) {
        //Map에 저장할 배열값
        String[] msg = {"AA","BB","CC","AA","EE","FF"};
        HashMap<Integer,String> map  = new HashMap<>();  //Integer,String 타입 만 저장하겠다는것
        int cnt = 0;//배열의 시작 index값
        //배열의 갯수만큼 Map 저장
        for(String e: msg){
            map.put(cnt+1,e); //cnt + 1 : Map의 키값이 1부터!
            cnt++;
        }
        System.out.println("Map :"+map.size());  //위에서 작성한 HashMap 타입 참조변수 map의 사이즈 리턴
        //출력
        //키값을 가진 객체의 주소를 반환. ->set으로 추출
        Set<Integer> keys = map.keySet();     //set은 중복을 저장하지 않기 때문에 key로 사용.keySet() 메소드는 key값만 리턴.
                            //위에서                 
        for(Integer e : keys){
            //map.put(k,v) , map.get(key)
            System.out.println(map.get(e));// Map의 get(Object key) 메서드는 key객체에 대응하는 value객체를 찾아 반환한다.
                                           //위에서 key값을 다 뽑아왔으므로 key의 value에 해당하는 값이 모두 출력된다. 
        }
       //축약형
       //key와 value를 받아오기 위한 것.
       //entrySet(): key 와 value를 추출
       //Map.Entry<Integer,String> ->key와 value 값을 받아올 인터페이스 자료형
        for(Map.Entry<Integer,String> e : map.entrySet()){
            System.out.println("Key: "+e.getKey());         
            System.out.println("Value: "+e.getValue());
        }
        
    }
}
