/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.math.MathContext;
import javax.swing.JFrame;

public class MyCanVasMock extends JFrame{
    private int arcNum = 360;
    private int x,y;
    public MyCanVasMock(){
        Canvas can = new Canvas(){
            
            //repaint() => JVM => update() => paint()
            @Override
            public void update(Graphics g) {
                paint(g);
            }
            //캔버스에 그린 그림을 지워주는 동작 수행
            //캔버스에 그림을 그려주는 동작 수행
            @Override
            public void paint(Graphics g) {
                g.setColor(Color.red);
                g.drawArc(100, 100, 100, 100, 0, arcNum);
            }
            
        };
        add(can);
        can.setBackground(Color.yellow);
        setBounds(100,100,300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MyCanVasMock();
    }
}
