package ex1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex2_Demo extends JFrame{
	private JPanel p; //패널 객체
	private JButton b; //버튼 객체
	public Ex2_Demo() {
		setTitle("테스트!"); //JFrame 부모의 자원을 사용
		add(p = new JPanel()); //마찬가지
		p.add(b=new JButton("Click"));
		//event 핸들링!
		b.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hi!!");
				p.setBackground(Color.green);
			}
		});
		p.setBackground(Color.red);
		//프로그램 종료!
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100,100,300,200);
		//창을 활성화
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Ex2_Demo();
	}

}
