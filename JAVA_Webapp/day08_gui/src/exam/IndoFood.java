package exam;

public class IndoFood implements MyInter{ //MyInter ����.
	 public String food(String name){
            int menu = (int)(Math.random()*3)+1;
            StringBuffer sb = new StringBuffer();
            switch(menu){
                case 1:
                    sb.append(name+"���� ī���� �ֹ�\n");
                    break;
                case 2:
                    sb.append(name+"���� ���� �ֹ�\n");
                    break;
                case 3:
                    sb.append(name+"���� ź�θ��� �ֹ�\n");
                    break;
            }
            return sb.toString();
        }

}
