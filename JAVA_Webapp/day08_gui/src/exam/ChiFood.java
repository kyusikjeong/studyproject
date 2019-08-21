
package exam;
public class ChiFood implements MyInter{
    public String food(String name){
            int menu = (int)(Math.random()*3)+1;
            StringBuffer sb = new StringBuffer();
            switch(menu){
                case 1:
                    sb.append(name+"¥‘¿Ã »Ã±≈∏¶ ¡÷πÆ\n");
                    break;
                case 2:
                    sb.append(name+"¥‘¿Ã ∏∂∂Û≈¡¿ª ¡÷πÆ\n");
                    break;
                case 3:
                    sb.append(name+"¥‘¿Ã ∆»∫∏√§∏¶ ¡÷πÆ\n");
                    break;
            }
            return sb.toString();
    }
}
