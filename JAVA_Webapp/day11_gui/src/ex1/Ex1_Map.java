package ex1;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public class Ex1_Map {
    public static void main(String[] args) {
        //Map�� ������ �迭��
        String[] msg = {"AA","BB","CC","AA","EE","FF"};
        HashMap<Integer,String> map  = new HashMap<>();  //Integer,String Ÿ�� �� �����ϰڴٴ°�
        int cnt = 0;//�迭�� ���� index��
        //�迭�� ������ŭ Map ����
        for(String e: msg){
            map.put(cnt+1,e); //cnt + 1 : Map�� Ű���� 1����!
            cnt++;
        }
        System.out.println("Map :"+map.size());  //������ �ۼ��� HashMap Ÿ�� �������� map�� ������ ����
        //���
        //Ű���� ���� ��ü�� �ּҸ� ��ȯ. ->set���� ����
        Set<Integer> keys = map.keySet();     //set�� �ߺ��� �������� �ʱ� ������ key�� ���.keySet() �޼ҵ�� key���� ����.
                            //������                 
        for(Integer e : keys){
            //map.put(k,v) , map.get(key)
            System.out.println(map.get(e));// Map�� get(Object key) �޼���� key��ü�� �����ϴ� value��ü�� ã�� ��ȯ�Ѵ�.
                                           //������ key���� �� �̾ƿ����Ƿ� key�� value�� �ش��ϴ� ���� ��� ��µȴ�. 
        }
       //�����
       //key�� value�� �޾ƿ��� ���� ��.
       //entrySet(): key �� value�� ����
       //Map.Entry<Integer,String> ->key�� value ���� �޾ƿ� �������̽� �ڷ���
        for(Map.Entry<Integer,String> e : map.entrySet()){
            System.out.println("Key: "+e.getKey());         
            System.out.println("Value: "+e.getValue());
        }
        
    }
}
