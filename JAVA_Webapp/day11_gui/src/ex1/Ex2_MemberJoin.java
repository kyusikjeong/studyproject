package ex1;

import java.util.ArrayList;
import java.util.Map;

public class Ex2_MemberJoin implements Ex2_MemberJoinInter{
    //������Ҹ� ���� �ʵ带 ����
    //���Ŀ��� ���Ⱑ ���� ������Ҹ� ���� ��ü....
    
    private ArrayList<Map<String,String>> list;
    public Ex2_MemberJoin(){
        list = new ArrayList<>();
    }
    //�Էµ� �� ���� üũ�ϴ� �޼���
    private boolean checkValue(){
        //Ư�� ���� �޾Ƽ� ���� ���� �ִ��� ������ üũ
        //��������(����,����...��)
        return true;
    }
    //ȸ���� ������ �Է¹��� Map�� �ּҸ� list�� ����
    
    @Override
    public void setAddMember(Map<String,String> map){
//        if(!checkValue()){ //���� Ŭ������ �ٽ� ����� �� �ִ�.
//            System.out.println("ȸ������ ���� ����!");
//            
//        }
        list.add(map);
    }
    @Override
    public ArrayList<Map<String, String>> getList() {
        //�ļ� ����� �� �� �ִ�.
        return list;
    }
    
    
    
}
