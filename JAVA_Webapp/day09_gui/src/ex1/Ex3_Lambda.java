/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author KOSTA
 */
public class Ex3_Lambda {
    public static void main(String[] args) {
        System.out.println("Result "+new MyInter2(){
            @Override
            public int myMethod(int x , int y){
                return x+y;
            }
        }.myMethod(10, 20));
        //���ٽ����� ǥ��
        MyInter2 mi;
        mi = (x,y)->{
           
            return x+y;
        };
        System.out.println(mi.myMethod(10, 30));
        //���Ϲ��� ������
        MyInter2 myinter3 = (x,y)->x*y;
        System.out.println("Result  :"+myinter3.myMethod(10, 32));
    }
}
