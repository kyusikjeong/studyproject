package ex2;

import java.util.Set;
import java.util.TreeSet;


public class Exam1_LottoDemo {
    private Set<Integer> s;

    public Set<Integer> getS() {
        return s;
    }
    
    public Exam1_LottoDemo(){
        s = new TreeSet<>();
    }
    
    public void returnLotto(){
        while(s.size()<6){
            s.add((int)(Math.random()*45)+1);
        }
    }
    
    public static void main(String[] args) {
        Exam1_LottoDemo e=new Exam1_LottoDemo();
        e.returnLotto();
        System.out.println("금주의 번호");
        for(int x: e.s){
            System.out.print(x+"  ");
        }
    }
}