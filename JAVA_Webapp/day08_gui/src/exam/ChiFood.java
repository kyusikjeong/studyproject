
package exam;
public class ChiFood implements MyInter{
    public String food(String name){
            int menu = (int)(Math.random()*3)+1;
            StringBuffer sb = new StringBuffer();
            switch(menu){
                case 1:
                    sb.append(name+"���� �̱Ÿ� �ֹ�\n");
                    break;
                case 2:
                    sb.append(name+"���� �������� �ֹ�\n");
                    break;
                case 3:
                    sb.append(name+"���� �Ⱥ�ä�� �ֹ�\n");
                    break;
            }
            return sb.toString();
    }
}
