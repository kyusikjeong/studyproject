/*
���ݱ��� �н��� ���� Ŭ������ Ȱ���ϴ� ��� �˾ƺ���
 */
package ex1;

//JFrame �� ��� �޾Ƽ� GUI ȭ���� �����ϴ� Ŭ������ ����
import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Alert;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//�̺�Ʈ�� �ڵ鸵�ϴ� �������̽��� ����ؼ� ����
//�������̽��� ������ �ؼ� ����ؾ� �Ѵ�.****** 
//Click �̺�Ʈ ó���� �������ִ� �������̽��� ActionListener�� �����Ѵ�.

                                                                    //������ �������̽� �ڿ� alt+enter
public class InnerClassDemo extends JFrame implements ActionListener{
    
    //JFrame �� ������ GUI��ü�� ����
    private JPanel p1,p2;
    private JButton b1,b2,b3;
    
    //alt+insert ������ ������ ����. �ƹ��͵� �������� ������ ����Ʈ ������ ����
    public InnerClassDemo() {
        //������ GUI ��ü�� �ʱ�ȭ(����)
        p1 = new JPanel();
        p2 = new JPanel();
        b1 = new JButton("red");
        b2 = new JButton("green");
        b3 = new JButton("blue");
         
        //p1,p2�� ������ ����
        p1.setBackground(Color.white); //pojo.. set get �����غ���.
        b1.setBackground(Color.red);
        b2.setBackground(Color.green);
        b3.setBackground(Color.blue);
         
       
        //p2�гο� ��ư�� ��ġ.
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
        //JFrame�� p1,p2 �г��� ��ġ.
        add(p1);
        add(p2,BorderLayout.SOUTH);
       // add(p2,"south");
       //ȭ�� Ȱ��ȭ �� ���� ó��.. ũ�� �� ��ġ
        setDefaultCloseOperation(EXIT_ON_CLOSE); //�ݱ��ư �������� �׼�
        setBounds(100, 100, 300, 450); 
        setVisible(true);
        //��ư�� �̺�Ʈ�� ���� �ϵ��� ����
        //b1.addActionListener(AcionListener�������̽��� ������ ��ü�� �ּҰ�)
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        new InnerClassDemo();
       
    }
    
    //��ư�� green, blue ���� �߰��ϰ� �ش� p1�� ������ ����
//ActionListener �������̽��� �߻� �޼��带 �������Ѵ�.
    @Override
    public void actionPerformed(ActionEvent e) {
        //shift +del �ϸ� ���� ������
        System.out.println("Click!");
        //Ŭ���� ��ư�� �ּҰ��� btn�� �����Ѵ�.
        JButton btn = (JButton)e.getSource();
        
        p1.setBackground(btn.getBackground());//������ ��
//        if(btn == b1){
//            System.out.println("b1 ��ư Ŭ��");
//            p1.setBackground(Color.red);
//        } else if (btn == b2){
//            System.out.println("b2 ��ư Ŭ��");
//            p1.setBackground(Color.green);
//        }else if(btn == b3){
//            System.out.println("b3 ��ư Ŭ��");
//            p1.setBackground(Color.blue);
//        }
            
        
    }
    
    
}
