package exam;

public class IndoFood implements MyInter{ //MyInter 구현.
	 public String food(String name){
            int menu = (int)(Math.random()*3)+1;
            StringBuffer sb = new StringBuffer();
            switch(menu){
                case 1:
                    sb.append(name+"님이 카레를 주문\n");
                    break;
                case 2:
                    sb.append(name+"님이 난을 주문\n");
                    break;
                case 3:
                    sb.append(name+"님이 탄두리를 주문\n");
                    break;
            }
            return sb.toString();
        }

}
