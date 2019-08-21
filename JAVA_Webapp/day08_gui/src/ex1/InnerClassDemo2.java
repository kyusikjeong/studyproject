/*
지금까지 학습한 내부 클래스를 활용하는 방법 알아보기
 */
package ex1;

//JFrame 을 상속 받아서 GUI 화면을 구성하는 클래스를 정의
import com.sun.java.swing.plaf.windows.resources.windows;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.scene.control.Alert;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
//이벤트는 핸들링하는 인터페이스를 사용해서 제어
//인터페이스는 재정의 해서 사용해야 한다.****** 
//Click 이벤트 처리를 지원해주는 인터페이스인 ActionListener를 구현한다.

                                                                    //구현할 인터페이스 뒤에 alt+enter
public class InnerClassDemo extends JFrame implements ActionListener{
    
    //JFrame 에 구성될 GUI객체를 선언
    private JPanel p1,p2;
    private JButton b1,b2,b3;
    
    //alt+insert 누르고 생성자 생성. 아무것도 선택하지 않으면 디폴트 생성자 생성
    public InnerClassDemo() {
        //선언한 GUI 객체를 초기화(생성)
        p1 = new JPanel();
        p2 = new JPanel();
        b1 = new JButton("red");
        b2 = new JButton("green");
        b3 = new JButton("blue");
         
        //p1,p2에 배경색을 적용
        p1.setBackground(Color.white); //pojo.. set get 생각해보자.
        b1.setBackground(Color.red);
        b2.setBackground(Color.green);
        b3.setBackground(Color.blue);
         
       
        //p2패널에 버튼을 배치.
        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        
        //JFrame에 p1,p2 패널을 배치.
        add(p1);
        add(p2,BorderLayout.SOUTH);
       // add(p2,"south");
       //화면 활성화 및 종료 처리.. 크기 및 위치
        setDefaultCloseOperation(EXIT_ON_CLOSE); //닫기버튼 눌렀을때 액션
        setBounds(100, 100, 300, 450); 
        setVisible(true);
        //버튼에 이벤트를 감지 하도록 설정
        //b1.addActionListener(AcionListener인터페이스를 구현한 객체의 주소값)
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
    }
    
    public static void main(String[] args) {
        new InnerClassDemo();
       
    }
    
    //버튼을 green, blue 각각 추가하고 해당 p1의 배경색을 지정
//ActionListener 인터페이스의 추상 메서드를 재정의한다.
    @Override
    public void actionPerformed(ActionEvent e) {
        //shift +del 하면 한줄 삭제됨
        System.out.println("Click!");
        //클릭한 버튼의 주소값을 btn에 저장한다.
        JButton btn = (JButton)e.getSource();
        
        p1.setBackground(btn.getBackground());//실행이 됨
//        if(btn == b1){
//            System.out.println("b1 버튼 클릭");
//            p1.setBackground(Color.red);
//        } else if (btn == b2){
//            System.out.println("b2 버튼 클릭");
//            p1.setBackground(Color.green);
//        }else if(btn == b3){
//            System.out.println("b3 버튼 클릭");
//            p1.setBackground(Color.blue);
//        }
            
        
    }
    
    
}
