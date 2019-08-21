package ex1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex2_Mock {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Ex2_MemberJoinInter ref = new Ex2_MemberJoin();
        while(true){
            System.out.println("메뉴   1:입력, 2:출력, 3:종료");
            String menu =sc.nextLine();
            switch(menu){
                case "1":
                    Map<String,String> map = new HashMap<>();
                    System.out.println("아이디: ");
                    map.put("id",sc.nextLine());
                    System.out.println("이름: ");
                    map.put("name",sc.nextLine());
                    System.out.println("나이: ");
                    map.put("age",sc.nextLine());
                    
                    ref.setAddMember(map);
                case "2":
                    printList(ref);
                case "3":
                    System.out.println("종료");
                    break;
                    
            } 
        }
    }
    
    
    private static void printList(Ex2_MemberJoinInter ref){
        ArrayList<Map<String,String>> map = ref.getList();
        StringBuffer sb = new StringBuffer();
        for(Map<String,String> e : map){
            sb.append("ID: ").append(e.get("id")).append("\t ");
            sb.append("Name: ").append(e.get("name")).append("\t ");
            sb.append("Age: ").append(e.get("age")).append("\t ");
        }
        System.out.println(sb);
    }
}
