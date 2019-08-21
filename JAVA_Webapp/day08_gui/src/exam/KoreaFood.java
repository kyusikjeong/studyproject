package exam;

public class KoreaFood extends Food implements MyInter{ //MyInter 구현.
    public String food(String name){
            int menu = (int)(Math.random()*3)+1;
            StringBuffer sb = new StringBuffer();   //주문자 값을 전달받고, 랜덤 함수를 사용하여 랜덤하게 메뉴를 출력한다.
            switch(menu){
                case 1:
                    sb.append(name+"님이 된장찌개 주문\n");
                    break;
                case 2:
                    sb.append(name+"님이 김치찌개 주문\n");
                    break;
                case 3:
                    sb.append(name+"님이 비빔밥 주문\n");
                    break;
            }
//            switch(menu){
//                case 1:
//                    sb.append(printFood(name,"한국","된장찌개"));  
//                    break;
//                case 2:
//                    sb.append(printFood(name,"한국","김치찌개"));
//                    break;
//                case 3:
//                    sb.append(printFood(name,"한국","비빔밥"));
//                    break;
//            }
            return sb.toString();        
        }

}
