package ex1;

import java.util.ArrayList;
import java.util.Map;

public class Ex2_MemberJoin implements Ex2_MemberJoinInter{
    //저장장소를 가진 필드를 선언
    //추후에는 여기가 실제 저장장소를 가진 객체....
    
    private ArrayList<Map<String,String>> list;
    public Ex2_MemberJoin(){
        list = new ArrayList<>();
    }
    //입력될 때 값을 체크하는 메서드
    private boolean checkValue(){
        //특정 값을 받아서 여기 값이 있는지 없는지 체크
        //제약조건(나이,성별...등)
        return true;
    }
    //회원의 정보를 입력받은 Map의 주소를 list에 저장
    
    @Override
    public void setAddMember(Map<String,String> map){
//        if(!checkValue()){ //현재 클래스의 핵심 기능일 수 있다.
//            System.out.println("회원가입 정보 누락!");
//            
//        }
        list.add(map);
    }
    @Override
    public ArrayList<Map<String, String>> getList() {
        //후속 기능이 올 수 있다.
        return list;
    }
    
    
    
}
