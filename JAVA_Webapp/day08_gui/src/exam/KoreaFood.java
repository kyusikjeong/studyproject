package exam;

public class KoreaFood extends Food implements MyInter{ //MyInter ����.
    public String food(String name){
            int menu = (int)(Math.random()*3)+1;
            StringBuffer sb = new StringBuffer();   //�ֹ��� ���� ���޹ް�, ���� �Լ��� ����Ͽ� �����ϰ� �޴��� ����Ѵ�.
            switch(menu){
                case 1:
                    sb.append(name+"���� ����� �ֹ�\n");
                    break;
                case 2:
                    sb.append(name+"���� ��ġ� �ֹ�\n");
                    break;
                case 3:
                    sb.append(name+"���� ����� �ֹ�\n");
                    break;
            }
//            switch(menu){
//                case 1:
//                    sb.append(printFood(name,"�ѱ�","�����"));  
//                    break;
//                case 2:
//                    sb.append(printFood(name,"�ѱ�","��ġ�"));
//                    break;
//                case 3:
//                    sb.append(printFood(name,"�ѱ�","�����"));
//                    break;
//            }
            return sb.toString();        
        }

}
